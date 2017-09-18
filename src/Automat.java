import java.util.*;

public class Automat {
    private ArrayList<List<AutomatStep>> steps;//шаги автомата. внутри листов храним те шаги, которые имеют одинаковый стартовы индекс (thisStepNumber)
    public Automat(){
        steps = new ArrayList<List<AutomatStep>>();
    }
    public Automat(ArrayList<List<AutomatStep>> steps) {
        this.steps = steps;
    }
    public void addStep(int thisStepNumber, int toStepNumber, String whatDoOnThisStep, boolean startStep, boolean finalStep){
        AutomatStep automatStep = new AutomatStep(thisStepNumber,toStepNumber,whatDoOnThisStep,startStep,finalStep);
        //создаем временный List
        //если массив пустой то просто добавляем
        if(steps.isEmpty()){
            List<AutomatStep> automatStepLinkedList = new LinkedList<AutomatStep>();//список для выходящих линий
            automatStepLinkedList.add(automatStep);
            steps.add(0,automatStepLinkedList);
        }
        else{
            if(thisStepNumber<steps.size()){
                //если у меня уже есть ячейка с таким стартовым номером
                List<AutomatStep> automatStepList = steps.get(thisStepNumber);
                automatStepList.add(automatStep);
                steps.set(thisStepNumber,automatStepList);
            }
            else {
                //если элемента нет
                List<AutomatStep> automatStepList = new LinkedList<AutomatStep>();
                automatStepList.add(automatStep);
                steps.add(thisStepNumber,automatStepList);
            }
        }
    }
    public boolean isStringNumber(String string){
        //325
        //проверяем сколько веток от узла
            //если ветка одна проверяем возможность перехода
            //если веток несколько проверяем возможность перехода на каждую из веток пока не найдем подходящую, если подхлдящая не найдена возвращаем false,
        //проверяем является ли узел финальным, если да то бесконечный цикл пока истина

        //проходим по всем элеметам листа
        //проходим по всем узлам автомата
        int numberOfCheckedSymbols = 0;
        for (int stepposition = 0; stepposition < steps.size(); stepposition++) {
            //если из автомата идет только один путь и узел автомата не финальный
            if(steps.get(stepposition).size() == 1 && !steps.get(stepposition).get(0).isFinalStep()){
                //проверяем можем ли мы по нему идти
                //если да то continue
                if(canGo(string,stepposition,0,numberOfCheckedSymbols)) {
                    //определяем куда мы можем идти
                    stepposition = steps.get(stepposition).get(0).getToStepNumber() - 1; //-1 так как в цикле позиция увеличится на 1
                    numberOfCheckedSymbols++;
                }
                else
                    break;
            }
            //если из автомата идет один путь и узел финальный
            else if(steps.get(stepposition).size() == 1 && steps.get(stepposition).get(0).isFinalStep()){
                while (canGo(string,stepposition,0,numberOfCheckedSymbols)){
                    numberOfCheckedSymbols++;
                }
                return string.length() - numberOfCheckedSymbols == 0;
            }
            //если из автомата идет несколько путей
            else if(steps.get(stepposition).size() > 1){
                //по какому из путей мы можем идти
                int temp = numberOfCheckedSymbols;
                for (int lineposition = 0; lineposition < steps.get(stepposition).size(); lineposition++) {
                    if(canGo(string,stepposition,lineposition,numberOfCheckedSymbols)){
                        stepposition = steps.get(stepposition).get(lineposition).getToStepNumber() - 1;
                        numberOfCheckedSymbols++;
                        break;
                    }
                }
                if(temp == numberOfCheckedSymbols)
                    break;
            }
        }

        return false;
    }

    //передаем строку, передаем номер стартовый узел и номер линии перехода и начальный символ для проверки
    private boolean canGo(String string, int stepposition,int lineposition,int startupSymbol) {
        if(startupSymbol > string.length()-1)
            return false;
        AutomatStep automatStep = steps.get(stepposition).get(lineposition);//узел автомата
        for (char c:automatStep.getWhatDoOnThisStep().toCharArray()) {
            if(string.charAt(startupSymbol) == c)
                return true;
        }
        return false;
    }

    private int checkNumberList(int index) {
        return steps.get(index).size();
    }

    public void printList(){
        for (int i = 0; i < steps.size(); i++) {
            for (int j = 0; j < steps.get(i).size(); j++) {
                System.out.println(steps.get(i).get(j).toString());
            }
        }
    }
}
