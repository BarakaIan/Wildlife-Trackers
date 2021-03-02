package dao;

public interface NonEndangeredAnimalDao {

    //LIST
    List<NonEndangeredSpecie> getAllNonEndangeredSpecie();

    //CREATE
    void save(NonEndangeredSpecie animal);

    //DELETE
    void clearAllNonEndangeredAnimals();
}
