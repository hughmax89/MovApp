package com.hgs.movapp.item;

public class ItemGabinete {

    private String GabineteId;
    private String Name;
    private String Description;
    private String Logo;
    private String TypeRelation;
    private int ProfessionalsCount;

    public String getGabineteId() {
        return GabineteId;
    }
    public void getGabineteId(String CategoryId) {
        this.GabineteId = CategoryId;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }

    public String getDescription() {
        return Description;
    }
    public void getDescription(String description) { this.Description = description; }

    public String getLogo() {
        return Logo;
    }
    public void setLogo(String logo) { this.Logo = logo; }

    public String getTypeRelation() {return TypeRelation;}
    public void setTypeRelation(String typeRelation) {
        this.TypeRelation = typeRelation;
    }

    public int getProfessionalsCount() {
        return ProfessionalsCount;
    }
    public void getProfessionalsCount(int ProfessionalsCount) { this.ProfessionalsCount = ProfessionalsCount; }



}
