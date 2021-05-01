public class AreaStringOutputter{

    SumProvider areaAggregator;
    AreaStringOutputter(SumProvider areaAggregator){
        this.areaAggregator = areaAggregator;
    }

    public String output(){
        return "Sum of areas: " + areaAggregator.sum();
    }
}
