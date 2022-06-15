package udemy.composition.entities;

import udemy.composition.entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Departament departament;
    private final List<HourContract> hourContracts = new ArrayList<>();

    public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public void addContract(HourContract contract) {
        hourContracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        hourContracts.remove(contract);
    }

    public Double income(int year, int month) {
        double sum = baseSalary;
        Calendar calendar = Calendar.getInstance();
        for (HourContract hourContract : hourContracts) {
            calendar.setTime(hourContract.getDate());
            int contractYear = calendar.get(Calendar.YEAR);
            int contractMonth = 1 + calendar.get(Calendar.MONTH);
            if (contractYear == year && contractMonth == month) {
                sum += hourContract.getValuePerHour();
            }
        }
        return sum;
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
}
