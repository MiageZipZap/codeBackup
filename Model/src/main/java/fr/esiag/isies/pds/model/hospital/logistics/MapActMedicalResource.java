package fr.esiag.isies.pds.model.hospital.logistics;


import fr.esiag.isies.pds.model.AbstractModel;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;
import fr.esiag.isies.pds.model.referential.person.staff.Profession;

public class MapActMedicalResource extends AbstractModel{
private Profession profession;
private String actMedical;
private TypeRefInfra typeRefInfraEquipment;
private TypeRefInfra typeRefInfraInfra;
public Profession getProfession() {
	return profession;
}
public void setProfession(Profession profession) {
	this.profession = profession;
}
public String getActMedical() {
	return actMedical;
}
public void setActMedical(String actMedical) {
	this.actMedical = actMedical;
}
public TypeRefInfra getTypeRefInfraEquipment() {
	return typeRefInfraEquipment;
}
public void setTypeRefInfraEquipment(TypeRefInfra typeRefInfraEquipment) {
	this.typeRefInfraEquipment = typeRefInfraEquipment;
}
public TypeRefInfra getTypeRefInfraInfra() {
	return typeRefInfraInfra;
}
public void setTypeRefInfraInfra(TypeRefInfra typeRefInfraInfra) {
	this.typeRefInfraInfra = typeRefInfraInfra;
}

}

