public class AutomatStep {
    private int thisStepNumber;
    private int toStepNumber;
    private String whatDoOnThisStep;
    private boolean startStep;
    private boolean finalStep;

    public AutomatStep() {
        thisStepNumber = -1;
        toStepNumber = -1;
        whatDoOnThisStep = "";
        startStep = false;
        finalStep = false;
    }

    public AutomatStep(int thisStepNumber, int toStepNumber, String whatDoOnThisStep, boolean startStep, boolean finalStep) {
        this.thisStepNumber = thisStepNumber;
        this.toStepNumber = toStepNumber;
        this.whatDoOnThisStep = whatDoOnThisStep;
        this.startStep = startStep;
        this.finalStep = finalStep;
    }

    public int getThisStepNumber() {
        return thisStepNumber;
    }

    public void setThisStepNumber(int thisStepNumber) {
        this.thisStepNumber = thisStepNumber;
    }

    public int getToStepNumber() {
        return toStepNumber;
    }

    public void setToStepNumber(int toStepNumber) {
        this.toStepNumber = toStepNumber;
    }

    public String getWhatDoOnThisStep() {
        return whatDoOnThisStep;
    }

    public void setWhatDoOnThisStep(String whatDoOnThisStep) {
        this.whatDoOnThisStep = whatDoOnThisStep;
    }

    public boolean isStartStep() {
        return startStep;
    }

    public void setStartStep(boolean startStep) {
        this.startStep = startStep;
    }

    public boolean isFinalStep() {
        return finalStep;
    }

    public void setFinalStep(boolean finalStep) {
        this.finalStep = finalStep;
    }

    @Override
    public String toString() {
        return "AutomatStep{" +
                "thisStepNumber=" + thisStepNumber +
                ", toStepNumber=" + toStepNumber +
                ", whatDoOnThisStep='" + whatDoOnThisStep + '\'' +
                ", startStep=" + startStep +
                ", finalStep=" + finalStep +
                '}';
    }
}
