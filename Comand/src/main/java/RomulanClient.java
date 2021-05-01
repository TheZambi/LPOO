public class RomulanClient extends AlienClient  {
    @Override
    protected OrderingStrategy createOrderingStrategy() {
        ImpatientStrategy strat = new ImpatientStrategy();
        return strat;
    }
}
