import lab01.tdd.*;

import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    SimpleCircularList simpleCircularList;
    StrategyFactory strategyFactory;
    final int elementToAdd = 1;
    final int elementToAdd2 = 2;
    final int elementToAdd3 = 3;
    final int elementToAdd4 = 4;


    @BeforeEach
    public void testBeforeEach(){
        simpleCircularList = new SimpleCircularList();
        strategyFactory = new StrategyFactoryImpl();
    }

    @Test
    public void testSize(){
        assertEquals(0, simpleCircularList.size());
    }

    @Test
    public void testIsEmpty(){
        assertTrue(simpleCircularList.isEmpty());
    }

    @Test
    public void testAdd(){
        simpleCircularList.add(elementToAdd);
        assertNotEquals(0, simpleCircularList.size());
    }

    @Test
    public void testNextEmpty(){
        assertEquals(Optional.empty(), simpleCircularList.next());
    }

    @Test
    public void testNext(){
        simpleCircularList.add(elementToAdd);
        assertEquals(Optional.of(elementToAdd), simpleCircularList.next());
    }

    @Test
    public void testNextCircular(){
        simpleCircularList.add(elementToAdd);
        simpleCircularList.add(elementToAdd2);
        simpleCircularList.next();
        simpleCircularList.next();
        assertEquals(Optional.of(elementToAdd), simpleCircularList.next());
    }

    @Test
    public void testNextWithPrevious(){
        simpleCircularList.add(elementToAdd);
        simpleCircularList.add(elementToAdd2);
        simpleCircularList.next();
        simpleCircularList.next();
        assertEquals(Optional.of(elementToAdd2), simpleCircularList.previous());
    }

    @Test
    public void testPreviousEmpty(){
        assertEquals(Optional.empty(), simpleCircularList.previous());
    }

    @Test
    public void testPrevious(){
        simpleCircularList.add(elementToAdd);
        assertEquals(Optional.of(elementToAdd), simpleCircularList.previous());
    }

    @Test
    public void testPreviousCircular(){
        simpleCircularList.add(elementToAdd);
        simpleCircularList.add(elementToAdd2);
        simpleCircularList.previous();
        simpleCircularList.previous();
        assertEquals(Optional.of(elementToAdd2), simpleCircularList.previous());
    }

    @Test
    public void testPreviousWithNext(){
        simpleCircularList.add(elementToAdd);
        simpleCircularList.add(elementToAdd2);
        simpleCircularList.previous();
        simpleCircularList.previous();
        assertEquals(Optional.of(elementToAdd), simpleCircularList.next());
    }

    @Test
    public void testReset(){
        simpleCircularList.add(elementToAdd);
        simpleCircularList.add(elementToAdd2);
        simpleCircularList.add(elementToAdd3);
        simpleCircularList.next();
        simpleCircularList.next();
        simpleCircularList.reset();
        assertEquals(Optional.of(elementToAdd), simpleCircularList.next());
    }

    @Test
    public void testEvenStrategy(){
        simpleCircularList.add(elementToAdd);
        simpleCircularList.add(elementToAdd2);
        simpleCircularList.add(elementToAdd3);
        simpleCircularList.add(elementToAdd4);
        simpleCircularList.next();
        simpleCircularList.next();
        assertEquals(Optional.of(elementToAdd4), simpleCircularList.next(strategyFactory.createEvenStrategy()));
    }

    @Test
    public void testEvenStrategyWithCircularity(){
        simpleCircularList.add(elementToAdd);
        simpleCircularList.add(elementToAdd2);
        simpleCircularList.add(elementToAdd3);
        simpleCircularList.next();
        simpleCircularList.next();
        assertEquals(Optional.of(elementToAdd2), simpleCircularList.next(strategyFactory.createEvenStrategy()));
    }

    @Test
    public void testMultipleOfStrategy(){
        simpleCircularList.add(elementToAdd);
        simpleCircularList.add(elementToAdd2);
        simpleCircularList.add(elementToAdd3);
        assertEquals(Optional.of(elementToAdd3), simpleCircularList.next(strategyFactory.createMultipleOfStrategy(3)));
    }

    @Test
    public void testEqualsStrategy(){
        simpleCircularList.add(elementToAdd);
        simpleCircularList.add(elementToAdd2);
        simpleCircularList.add(elementToAdd3);
        assertEquals(Optional.of(elementToAdd3), simpleCircularList.next(strategyFactory.createEqualsStrategy(3)));
    }
}
