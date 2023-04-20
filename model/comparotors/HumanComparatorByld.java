package model.comparotors;

public class HumanComparatorByld<H> implements Comparator<Human>{
@Override
public int compare(Human human_1, Human human_2) 
    return human_1.getId() - human_2.getId(); {
    }
}
