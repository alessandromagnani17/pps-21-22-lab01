package lab01.tdd;

public class StrategyFactoryImpl implements StrategyFactory {

    @Override
    public SelectStrategy createEvenStrategy() {
        return (x) -> x%2 == 0;
    }

    @Override
    public SelectStrategy createMultipleOfStrategy(int element) {
        return (x) -> x % element == 0;
    }

    @Override
    public SelectStrategy createEqualsStrategy(int element) {
        return (x) -> x == element;
    }
}
