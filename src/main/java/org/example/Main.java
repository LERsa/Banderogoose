package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main extends TelegramLongPollingBot
{
    // BanderoGooseGoITN3254Bot
    // 6200499633:AAGTW3sCnNgJ9725Jr-3bwDcPZY7bxY4At0
    private  Map<Long, Integer> levels = new HashMap<>();
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(new Main());
    }

    @Override
    public String getBotUsername() {
        return "BanderoGooseGoITN3254Bot";
    }

    @Override
    public String getBotToken() {
        return "6200499633:AAGTW3sCnNgJ9725Jr-3bwDcPZY7bxY4At0";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long chatID = GetChatId(update);
        if(update.hasMessage())
        {
            if(update.getMessage().getText().equals("/start"))
            {
                SendImage("level-1", chatID);
                SendMessage sendMessage = CreateMessage("Ґа-ґа-ґа!\n" +
                        "Вітаємо у боті біолабораторії «Батько наш Бандера».\n" +
                        "\n" +
                        "Ти отримуєш гусака №71\n" +
                        "\n" +
                        "Цей бот ми створили для того, щоб твій гусак прокачався з рівня звичайної свійської худоби до рівня біологічної зброї, здатної нищити ворога. \n" +
                        "\n" +
                        "Щоб звичайний гусак перетворився на бандерогусака, тобі необхідно:\n" +
                        "✔️виконувати завдання\n" +
                        "✔️переходити на наступні рівні\n" +
                        "✔️заробити достатню кількість монет, щоб придбати Джавеліну і зробити свєрхтра-та-та.\n" +
                        "\n" +
                        "*Гусак звичайний.* Стартовий рівень.\n" +
                        "Бонус: 5 монет.\n" +
                        "Обери завдання, щоб перейти на наступний рівень\n");
                sendMessage.setChatId(chatID);
                List<String> buttons = Arrays.asList
                        (
                                "Сплести маскувальну сітку (+15 монет)",
                                "Зібрати кошти патріотичними піснями (+15 монет)",
                                "Вступити в Міністерство Мемів України (+15 монет)",
                                "Запустити волонтерську акцію (+15 монет)",
                                "Вступити до лав тероборони (+15 монет)"
                        );
                buttons = getRandom3(buttons);
                AttachButtons(sendMessage, Map.of
                        (
                                buttons.get(0),"1LevelTask",
                                buttons.get(1),"1LevelTask",
                                buttons.get(2),"1LevelTask"
                        ));
                sendApiMethodAsync(sendMessage);
            }
        }
        if (update.hasCallbackQuery())
        {
            if(update.getCallbackQuery().getData().equals("1LevelTask") && getLevel(chatID) == 1)
            {
                setLevel(chatID, 2);
                SendImage("level-2", chatID);
                SendMessage sendMessage = CreateMessage("\n" +
                        "*Вітаємо на другому рівні! Твій гусак - біогусак.*\n" +
                        "Баланс: 20 монет. \n" +
                        "Обери завдання, щоб перейти на наступний рівень");
                sendMessage.setChatId(chatID);
                List<String> buttons = Arrays.asList
                        (
                                "Зібрати комарів для нової біологічної зброї (+15 монет)",
                                "Пройти курс молодого бійця (+15 монет)",
                                "Задонатити на ЗСУ (+15 монет)",
                                "Збити дрона банкою огірків (+15 монет)",
                                "Зробити запаси коктейлів Молотова (+15 монет)"
                        );
                buttons = getRandom3(buttons);
                AttachButtons(sendMessage, Map.of
                        (
                                buttons.get(0),"2LevelTask",
                                buttons.get(1),"2LevelTask",
                                buttons.get(2),"2LevelTask"
                        ));
                sendApiMethodAsync(sendMessage);
            }
            if(update.getCallbackQuery().getData().equals("2LevelTask") && getLevel(chatID) == 2)
            {
                setLevel(chatID, 3);
                SendImage("level-3", chatID);
                SendMessage sendMessage = CreateMessage("\n" +
                        "*Вітаємо на третьому рівні! Твій гусак - бандеростажер.*\n" +
                        "Баланс: 35 монет. \n" +
                        "Обери завдання, щоб перейти на наступний рівень");
                sendMessage.setChatId(chatID);
                List<String> buttons = Arrays.asList
                        (
                                "Злітати на тестовий рейд по чотирьох позиціях (+15 монет)",
                                "Відвезти гуманітарку на передок (+15 монет)",
                                "Знайти зрадника та здати в СБУ (+15 монет)",
                                "Навести арту на орків (+15 монет)",
                                "Притягнути танк трактором (+15 монет)"
                        );
                buttons = getRandom3(buttons);
                AttachButtons(sendMessage, Map.of
                        (
                                buttons.get(0),"3LevelTask",
                                buttons.get(1),"3LevelTask",
                                buttons.get(2),"3LevelTask"
                        ));
                sendApiMethodAsync(sendMessage);
            }
            if(update.getCallbackQuery().getData().equals("3LevelTask") && getLevel(chatID) == 3)
            {
                setLevel(chatID, 4);
                SendImage("level-4", chatID);
                SendMessage sendMessage = CreateMessage("" +
                        "*Вітаємо на останньому рівні! Твій гусак - готова біологічна зброя - бандерогусак.*\n" +
                        "Баланс: 50 монет. \n" +
                        "Тепер ти можеш придбати Джавелін і глушити чмонь");
                sendMessage.setChatId(chatID);
                AttachButtons(sendMessage, Map.of
                        (
                                "Купити Джавелін (50 монет)","purchaseJavelin"
                        ));
                sendApiMethodAsync(sendMessage);
            }
            if(update.getCallbackQuery().getData().equals("purchaseJavelin") && getLevel(chatID) == 4)
            {
                setLevel(chatID, 5);
                SendMessage sendMessage = CreateMessage
                        (
                                "*Джавелін твій. Повний вперед!*"
                        );
                sendMessage.setChatId(chatID);
                sendApiMethodAsync(sendMessage);
                SendImage("final", chatID);
            }
        }
    }
    public Long GetChatId(Update update)
    {
        if(update.hasMessage())
        {
            return update.getMessage().getFrom().getId();
        }
        if (update.hasCallbackQuery())
        {
            return update.getCallbackQuery().getFrom().getId();
        }
        return  null;
    }
    public SendMessage CreateMessage(String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(new String(text.getBytes(), StandardCharsets.UTF_8));
        sendMessage.setParseMode("markdown");
        return  sendMessage;
    }
    public void AttachButtons(SendMessage sendMessage, Map<String, String> buttons)
    {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        for(String buttonName : buttons.keySet())
        {
            String buttonValue = buttons.get(buttonName);

            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText(new String(buttonName.getBytes(), StandardCharsets.UTF_8));
            inlineKeyboardButton.setCallbackData(buttonValue);

            keyboard.add(Arrays.asList(inlineKeyboardButton));
        }
        inlineKeyboardMarkup.setKeyboard(keyboard);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
    }
    public void SendImage(String imageName, Long chatID)
    {
        SendAnimation sendAnimation = new SendAnimation();

        InputFile inputFile = new InputFile();
        inputFile.setMedia(new File("Images/" + imageName + ".gif"));

        sendAnimation.setAnimation(inputFile);
        sendAnimation.setChatId(chatID);

        executeAsync(sendAnimation);
    }
    public  int getLevel(Long chatID)
    {
        return levels.getOrDefault(chatID, 1);
    }
    public void setLevel(Long chatID, int level)
    {
        levels.put(chatID, level);
    }
    public <T> List<T> getRandom3(List<T> variants)
    {
        ArrayList<T> copy = new ArrayList<>(variants);
        Collections.shuffle(copy);
        return copy.subList(0,3);
    }
}