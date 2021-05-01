public class FerengiClient extends AlienClient  {

    @Override
    protected OrderingStrategy createOrderingStrategy() {
        SmartStrategy strat = new SmartStrategy();
        return strat;
    }
}
