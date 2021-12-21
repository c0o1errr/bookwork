import java.util.ArrayList;

/* Создает объекты DotCom, получает пользовательский ввод, играет пока не потопяться все три сайта */
public class DotCom {
    private ArrayList<String> locationCells;   //ArrayList с ячейками описывающими местоположение сайтов
    private String name;

    public void setLocationCells(ArrayList<String> loc) { //Сеттер который обновляет местоположение сайта
        locationCells = loc;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String checkYourself(String userInput){
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);  // проверяем, содержится ли загаданная пользователем ячейка внути ArrayList, запрашивая её индекс. Если ее нет в списке то infexOf() возвращает -1
        if (index >=0) {                                //если индекс >= 0, то загаданная пользователем ячйка опеределннно находится в списке, поэтому удаляем ее
            locationCells.remove(index);
            if (locationCells.isEmpty()) {             //если список пустой, значит это было роковое попадание
                result = "Потопил";
                System.out.println("Ой! Ты убица сайта!!!" + name + " : ( ");
            } else {
                result = "Попал";
            }
        }
    return result;
    }
}
