public class AreaXMLOutputter{

    SumProvider areaAggregator;
    AreaXMLOutputter(SumProvider areaAggregator){
        this.areaAggregator = areaAggregator;
    }

    public String output(){
        return "<area>" + areaAggregator.sum() + "</area>";
    }
}
