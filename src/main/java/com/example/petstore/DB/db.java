package com.example.petstore.DB;

import com.example.petstore.Pet;
import com.example.petstore.PetType;

import java.util.ArrayList;
import java.util.List;

public class db {
    private static List<Pet> petTable=new ArrayList<Pet>();
    private static List<PetType> PetTypeTable=new ArrayList<PetType>();

    public static List<Pet> getPetTable(){
        return petTable;
    }

    public static List<PetType> getPetTypeTable(){
        return PetTypeTable;
    }

    public static Pet savePet(Pet pet){
        petTable.add(pet);
        return pet;
    }

    public static PetType savePetType(PetType type){
        PetTypeTable.add(type);
        return type;
    }

    public static Pet updatePet(Pet pet, Pet newPet){
        pet.setPetName(newPet.getPetName());
        pet.setPetAge(newPet.getPetAge());
        pet.setPetType(newPet.getPetType());
        return pet;
    }

    public static Pet updatePetType(PetType type, PetType newType){
        type.setPetTypeId(newType.getPetTypeId());
        type.setPetTypeName(newType.getPetTypeName());
        return type;
    }

    public static Pet deletePet(Pet pet){
        petTable.remove(pet);
        return pet;
    }

    public static PetType deleteType(PetType type){
        PettypeTable.remove(type);
        return type;
    }
}