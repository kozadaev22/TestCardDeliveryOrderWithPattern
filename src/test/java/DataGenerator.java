import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
    }

    public static String generateCity() {
        var city = new String[]{"Майкоп", "Махачкала", "Магас", "Йошкар-Ола", "Якутск", "Владикавказ",
                "Грозный", "Чита", "Петропавловск-Камчатский", "Краснодар", "Пермь", "Хабаровск", "Архангельск",
                "Белгород", "Брянск", "Воронеж", "Иркутск", "Калуга", "Санкт-Петербург", "Липецк", "Москва",
                "Мурманск", "Новосибирск", "Омск", "Оренбург", "Псков", "Ростов-на-Дону", "Рязань", "Южно-Сахалинск",
                "Екатеринбург", "Тверь", "Тула", "Тюмень", "Ульяновск", "Челябинск", "Ярославль"};
        return city[new Random().nextInt(city.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }

    public static class Regestration {
        private Regestration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }
}
