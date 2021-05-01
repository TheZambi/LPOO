import java.util.Collection;

public class GateNot implements LogicGate{
    private LogicVariable output;
    private LogicVariable[] inputs;
    public GateNot(LogicVariable out, LogicVariable in) throws ColisionException, CycleException {
        if(out.getWasCalced())
            throw new ColisionException();
        this.output = out;
        this.inputs = new LogicVariable[]{in};
        out.setValue(!in.getValue());
        out.setCalcBy(this);
        out.setWasCalced(true);
        if(out.isDep(in, out))
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
        return "NOT";
    }

    @Override
    public String getFormula() {
        return "NOT("+this.inputs[0].getFormula()+")";
    }

    public void recalc()
    {
        output.setValue(!this.inputs[0].getValue());
    }
}
