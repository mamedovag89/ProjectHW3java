package model.comparotors;


public class HumanComparatorByBirthday<H> implements Comparator<Human> {
    @Override
    public int compare(Human human_1, Human human_2) {
        return human_1.getBirthYear() - human_2.getBirthYear();
    }
    
}
