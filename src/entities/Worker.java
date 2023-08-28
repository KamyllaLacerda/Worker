package entities;

import entities.enuns.WorkerLevel;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Departament departament;
    private List<HourContract> hourContracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public List<HourContract> getHourContracts() {
        return hourContracts;
    }

    public void addContract(HourContract hourContract){
        this.hourContracts.add(hourContract);
    }
    public void removeContract(HourContract hourContract){
        this.hourContracts.remove(hourContract);
    }

    public Double income(Integer year, Integer month){
        double sum = baseSalary;
        for(HourContract contract : hourContracts){
            int contractYear = contract.getDate().getYear();
            int contractMonth = contract.getDate().getMonthValue();

            if(year == contractYear && month == contractMonth){
                sum += contract.totalValue();
            }
        }
        return sum;
    }
}
