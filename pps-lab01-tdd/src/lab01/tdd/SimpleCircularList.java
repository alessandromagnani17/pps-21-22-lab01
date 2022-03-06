package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList {

    List<Integer> arrayList = new ArrayList<>();
    private int index = 0;
    private int cont = 0;

    @Override
    public void add(int element) {
        arrayList.add(element);
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (arrayList.isEmpty()) return Optional.empty();

        index = index + 1;
        if (index == arrayList.size()+1) index = 1;
        return Optional.ofNullable(arrayList.get(index - 1));
    }

    @Override
    public Optional<Integer> previous() {
        if (arrayList.isEmpty()) return Optional.empty();

        index = index + 1;
        if (index == arrayList.size()+1) index = 1;
        return Optional.ofNullable(arrayList.get(arrayList.size() - index));
    }

    @Override
    public void reset() {
        index = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        cont = 0;

        while (cont != arrayList.size()) {
            if (strategy.apply(arrayList.get(index))) return Optional.ofNullable(arrayList.get(index));
            index = index + 1;
            if (index == arrayList.size()) index = 0;
            cont = cont + 1;
        }
        return Optional.empty();
    }
}
