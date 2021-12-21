import java.util.ArrayList;

public class DotComBust {

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuess = 0;

    //Создает объекты DotCom и выводит краткие инструкции пользователю
    private void setUpGame(){
        // Создадим несколько сайтов и присвоим им адреса
        DotCom one = new DotCom();
        one.setName("pets.com");
        DotCom two = new DotCom();
        two.setName("catzo.ru");
        DotCom three = new DotCom();
        three.setName("mail.ru");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Ваша цель потопить три сайта:" + "игровое поле от A до G");
        System.out.println("pets.com, catzo.ru, mail.ru");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов, указывая в формате A0-A6");

        for (DotCom dotComToSet:dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    //запрашивает у пользователя ход и вызывает метод checkUserGuess
    private void startPlaying(){
        while (!dotComList.isEmpty()) {
            String userGuess = helper.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    //просматривает все остальные объекты DotCom и вызывает каждый объект DotCom метода checkYourSelf
    private void checkUserGuess(String userGuess) {
        numOfGuess++;
        String result = "Мимо";

        for(DotCom dotComToTest: dotComList) {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Попал")) {
                break;
            }
            if (result.equals("Потопил")) {
                dotComList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);

    }

    private void finishGame(){
        System.out.println("Ура! Ты прошел игру! А теперь посмотри табоицу лидеров");
        if (numOfGuess < 18) {
            System.out.println("Это занело у вас" + numOfGuess + "попыток");
            System.out.println("Вы макака :D");
        } else {
            System.out.println("Это заняло у вас вечность, а точнее" + numOfGuess + "лет");
            System.out.printf("Рыба, рак, рука, ракета");
        }
    }


}
