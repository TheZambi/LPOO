import java.util.ArrayList;
import java.util.List;

public class CombinatorialCircuit {
    List<LogicVariable> variables = new ArrayList<>();


    public boolean addVariable(LogicVariable a) {
        for(LogicVariable lv : variables){
            if(a.getName().equals(lv.getName()))
                return false;
        }
        variables.add(a);
        return true;
    }

    public Object getVariableByName(String x1) {
        for(LogicVariable lv : variables){
            if(lv.getName().equals(x1))
                return lv;
        }
        return null;
    }
}
