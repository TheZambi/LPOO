public class GateOr implements LogicGate {
    private LogicVariable output;
    private LogicVariable[] inputs;

    public GateOr(LogicVariable out, LogicVariable in1, LogicVariable in2) throws ColisionException, CycleException {
        if(out.getWasCalced())
            throw new ColisionException();

        this.output = out;
        inputs = new LogicVariable[]{in1, in2};
        out.setValue(in1.getValue()||in2.getValue());
        out.setCalcBy(this);
        out.setWasCalced(true);
        if(out.isDep(in1, out))
            throw new CycleException();
        if(out.isDep(in2, out))
            throw new CycleException();
    }

    public LogicVariable getOutput() {
        return output;
    }

    public LogicVariable[] getInputs() {
        return inputs;
    }
    @Override
    public String getSymbol() {
        return "OR";
    }

    @Override
    public String getFormula() {
        return "OR("+this.inputs[0].getFormula()+","+this.inputs[1].getFormula()+")";
    }

    public void recalc()
    {
        output.setValue(this.inputs[0].getValue() || this.inputs[1].getValue());
    }
}
