import java.util.Objects;

public class LogicVariable {
    private String name;
    private boolean value;
    private LogicGate calcBy;
    private boolean wasCalced = true;



    public void setWasCalced(boolean wasCalced) {
        this.wasCalced = wasCalced;
    }

    public boolean getWasCalced() {
        return wasCalced;
    }

    public LogicVariable(String x1) {
        this.name = x1;
        this.value = false;
        calcBy = null;
        wasCalced = false;
    }

    public void setCalcBy(LogicGate calcBy) {
        this.calcBy = calcBy;
    }

    public LogicVariable(String x1, boolean b) {
        this.name = x1;
        this.value = b;
        calcBy = null;
    }

    public String getName() {
        return name;
    }

    public boolean getValue()
    {
        if(calcBy != null)
            calcBy.recalc();
        return this.value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogicVariable that = (LogicVariable) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public LogicGate getCalculatedBy() {
        return calcBy;
    }

    public String getFormula() {
        if(calcBy==null)
            return this.name;
        else
        {
            return calcBy.getFormula();
        }
    }

    public boolean isDep(LogicVariable lv, LogicVariable test)
    {
        if(lv.calcBy==null)
            return false;
        if(calcBy.getInputs()[0]==test)
            return true;

        if(test.calcBy instanceof GateNot)
        {
            return calcBy.getInputs()[0].isDep(calcBy.getInputs()[0],lv);
        }
        else
        {
            if(test.calcBy.getInputs()[1]==test)
                return true;
            if(test.calcBy.getInputs()[0].isDep(calcBy.getInputs()[0],lv))
                return true;
            return test.calcBy.getInputs()[1].isDep(calcBy.getInputs()[1],lv);
        }
    }
}
