import config.TelebotConfig;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Metfone_bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && !update.getMessage().getText().isEmpty()) {
            String chat_id = update.getMessage().getChatId().toString();
            String command = update.getMessage().getText();
            if (command.equals("/start")
                    || command.equals("ចាប់ផ្ដើម")
                    || command.equals("start")) {
                selectLanguage(chat_id);
            } else {
                selectLanguage(chat_id);
            }
        }
        else if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            SendChatAction sendChatAction = new SendChatAction();
            String chat_id = callbackQuery.getFrom().getId().toString();

            if (data.equals("enbutton")){
                selectServiceButtons(chat_id);
            }else if (data.equals("enbutton6")) {
                selectOthersEn(chat_id);
            }else if (data.equals("enbutton1")) {
                selectInernetPlansAndServices(chat_id);
            } else if (data.equals("enbutton2")) {
                mobileEn(chat_id);
            } else if (data.equals("mobileEn1")) {
                promotionEn(chat_id);
            } else if (data.equals("mobileEn3")) {
                prepaidEn(chat_id);
            } else if (data.equals("mobileEn2")) {
                selectInernetPlansAndServices(chat_id);
            } else if (data.equals("enbutton3")) {
                digitalServiceEn(chat_id);
            } else if (data.equals("digitalServiceEn1")) {
                digitalMusicEn(chat_id);
            } else if (data.equals("digitalServiceEn2")) {
                digitalUtilities(chat_id);
            } else if (data.equals("digitalServiceEn3")) {
                digitalInformation(chat_id);
            } else if (data.equals("digitalServiceEn4")) {
                digitalEntertainment(chat_id);
            }else if (data.equals("mobileKh1")) {
                promotionKh(chat_id);
            } else if (data.equals("mobileKh3")) {
                prepaidKh(chat_id);
            } else if (data.equals("mobileKh2")) {
                selectInernetPlansAndServicesKhmer(chat_id);
            } else if (data.equals("selectServiceButtonsKh1")) {
                selectInernetPlansAndServicesKhmer(chat_id);
            }
            else if (data.equals("selectServiceButtonsKh2")) {
                mobileKh(chat_id);
            }
            else if (data.equals("selectServiceButtonsKh3")) {
                digitalServiceKh(chat_id);
            }
            else if (data.equals("digitalServiceKh1")) {
                digitalMusicKh(chat_id);
            } else if (data.equals("digitalServiceKh2")) {
                digitalUtilitiesKh(chat_id);
            } else if (data.equals("digitalServiceKh3")) {
                digitalInformationKh(chat_id);
            } else if (data.equals("digitalServiceKh4")) {
                digitalEntertainmentKh(chat_id);
            }else if (data.equals("promotionEn1")||data.equals("promotionKh1")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                SendPhoto smg = new SendPhoto();
                smg.setChatId(chat_id);
                File imageFile = new File("E:\\Photo\\ExchangePlus.png");
                smg.setCaption("Tap on picture above from more details!");
                smg.setPhoto(new InputFile(imageFile));
                try {
                    execute(smg); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (data.equals("promotionEn2")||data.equals("promotionKh2")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                SendPhoto smg = new SendPhoto();
                smg.setChatId(chat_id);
                File imageFile = new File("E:\\Photo\\TiktokPlan.png");
                smg.setCaption("Tap on picture above from more details!");
                smg.setPhoto(new InputFile(imageFile));
                try {
                    execute(smg); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (data.equals("promotionEn3")||data.equals("promotionKh3")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                SendPhoto smg = new SendPhoto();
                smg.setChatId(chat_id);
                File imageFile = new File("E:\\Photo\\SabayLeng.png");
                smg.setCaption("Tap on picture above from more details!");
                smg.setPhoto(new InputFile(imageFile));
                try {
                    execute(smg); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (data.equals("Othersbutton0")){
                SendMessage message = new SendMessage();
                message.setChatId((chat_id));
                message.setText("Metfone prefixes number: \n031, 060, 066, 067, 068, 071, 088, 090 and 097.");
                try {
                    execute(message);
                } catch (TelegramApiException e){
                    e.printStackTrace();
                }
            }
            else if (data.equals("Othersbutton1")) {
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("To check your phone number: Dial *99#");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (data.equals("Othersbutton2")) {
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("To check your balance: Dial *097#");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (data.equals("buttons0")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                SendPhoto smg = new SendPhoto();
                smg.setChatId(chat_id);
                File imageFile = new File("E:\\Photo\\Super exchange khmer.png");
                smg.setCaption("Here is Super Exchange plan");
                smg.setPhoto(new InputFile(imageFile));
                try {
                    execute(smg); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }else if (data.equals("buttons1")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Generating Metfone Limited plan");
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                SendPhoto smg = new SendPhoto();
                smg.setChatId(chat_id);
                File imageFile = new File("E:\\Photo\\Limited plan.png");
                smg.setCaption("Here is metfone Limited plan");
                smg.setPhoto(new InputFile(imageFile));
                try {
                    execute(smg); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (data.equals("buttons2")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Generating Metfone Social Plan");
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                SendPhoto smg = new SendPhoto();
                smg.setChatId(chat_id);
                File imageFile = new File("E:\\Photo\\social plan.png");
                smg.setCaption("Here is metfone Social plan");
                smg.setPhoto(new InputFile(imageFile));

                try {
                    execute(smg); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (data.equals("buttons3")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Generating Metfone Youtube Plan");
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                SendPhoto smg = new SendPhoto();
                smg.setChatId(chat_id);
                File imageFile = new File("E:\\Photo\\youtube plan.png");
                smg.setCaption("Here is metfone Youtube plan");
                smg.setPhoto(new InputFile(imageFile));
                try {
                    execute(smg); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (data.equals("buttons4")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Generating Metfone MIU Plan");
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                SendPhoto smg = new SendPhoto();
                smg.setChatId(chat_id);

                File imageFile = new File("E:\\Photo\\Metfone MIU plan.png");

                smg.setCaption("Here is metfone MIU plan");
                smg.setPhoto(new InputFile(imageFile));

                try {
                    execute(smg); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }else if (data.equals("khbuttons0")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
                //    sendMessage.setText("Generating Metfone Limited plan");
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                SendPhoto smg = new SendPhoto();
                smg.setChatId(chat_id);
                File imageFile = new File("E:\\Photo\\Super exchange khmer.png");
                smg.setCaption("ប៉ះលើរូបភាពខាងលើដើម្បីមើលពត៌មានលម្អិត");
                smg.setPhoto(new InputFile(imageFile));
                try {
                    execute(smg); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (data.equals("khbuttons1")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
            //    sendMessage.setText("Generating Metfone Limited plan");
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                SendPhoto smg = new SendPhoto();
                smg.setChatId(chat_id);
                File imageFile = new File("E:\\Photo\\limited khmer.png");
                smg.setCaption("ប៉ះលើរូបភាពខាងលើដើម្បីមើលពត៌មានលម្អិត");
                smg.setPhoto(new InputFile(imageFile));
                try {
                    execute(smg); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (data.equals("khbuttons2")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
            //    sendMessage.setText("Generating Metfone Social Plan");
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                SendPhoto smg = new SendPhoto();
                smg.setChatId(chat_id);
                File imageFile = new File("E:\\Photo\\social khmer.png");
                smg.setCaption("ប៉ះលើរូបភាពខាងលើដើម្បីមើលពត៌មានលម្អិត");
                smg.setPhoto(new InputFile(imageFile));

                try {
                    execute(smg); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (data.equals("khbuttons3")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
             //   sendMessage.setText("Generating Metfone Youtube Plan");
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                SendPhoto smg = new SendPhoto();
                smg.setChatId(chat_id);
                File imageFile = new File("E:\\Photo\\youtubekhmer.png");
                smg.setCaption("ប៉ះលើរូបភាពខាងលើដើម្បីមើលពត៌មានលម្អិត");
                smg.setPhoto(new InputFile(imageFile));
                try {
                    execute(smg); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (data.equals("khbuttons4")) {
                sendChatAction.setChatId(chat_id);
                SendMessage sendMessage = new SendMessage();
              //  sendMessage.setText("Generating Metfone MIU Plan");
                sendMessage.setChatId(chat_id);
                try {
                    sendChatAction.setAction(ActionType.TYPING);
                    execute(sendChatAction);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                SendPhoto smg = new SendPhoto();
                smg.setChatId(chat_id);

                File imageFile = new File("E:\\Photo\\unlimited khmer.png");

                smg.setCaption("ប៉ះលើរូបភាពខាងលើដើម្បីមើលពត៌មានលម្អិត");
                smg.setPhoto(new InputFile(imageFile));

                try {
                    execute(smg); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (data.equals("khbutton")){
                selectServiceButtonsKh(chat_id);
            }else if (data.equals("buttonkh1")){
                selectInernetPlansAndServicesKhmer(chat_id);
            }
            else if (data.equals("selectOthersKh0")){
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("ក្បាលលេខសំគាល់ប្រព័ន្ធទូរសព្ទចល័តរបស់មិត្តហ្វូនរួមមាន៖ \n031, 060, 066, 067, 068, 071, 088, 090 និង 097 ។");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }else if (data.equals("selectServiceButtonsKh6")){
                selectOthersKh(chat_id);
            }else if (data.equals("selectOthersKh1")) {
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("ដើម្បីឆែកមើលលេខទូរសព្ទរបស់លោកអ្នក សូមចុច *99# រួចចុចបញ្ចូន!");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (data.equals("selectOthersKh2")) {
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("ដើម្បីឆែកមើលទឹកប្រាក់ក្នុងគណនីរបស់លោកអ្នក សូមចុច *097# រួចចុចបញ្ចូន!");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void selectLanguage (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("សូមមេត្តាជ្រើសរើសភាសា!\nPlease choose languages!");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> khbutton = new ArrayList<>();
        List<InlineKeyboardButton> enbutton = new ArrayList<>();

        InlineKeyboardButton Kh = new InlineKeyboardButton();
        InlineKeyboardButton En = new InlineKeyboardButton();

        Kh.setText("ភាសាខ្មែរ");
        En.setText("English");

        Kh.setCallbackData("khbutton");
        En.setCallbackData("enbutton");
        khbutton.add(Kh);
        enbutton.add(En);
        listInlineButton.add(khbutton);
        listInlineButton.add(enbutton);

        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void selectOthersEn (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Click button below to see more details!");

        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> Othersbutton0 = new ArrayList<>();
        List<InlineKeyboardButton> Othersbutton1 = new ArrayList<>();
        List<InlineKeyboardButton> Othersbutton2 = new ArrayList<>();
        List<InlineKeyboardButton> Othersbutton3 = new ArrayList<>();
        List<InlineKeyboardButton> Othersbutton4 = new ArrayList<>();

        InlineKeyboardButton OT0 = new InlineKeyboardButton();
        InlineKeyboardButton OT1 = new InlineKeyboardButton();
        InlineKeyboardButton OT2 = new InlineKeyboardButton();
        InlineKeyboardButton OT3 = new InlineKeyboardButton();
        InlineKeyboardButton OT4 = new InlineKeyboardButton();
        OT3.setUrl("https://metfone.com.kh/en");
        OT4.setUrl("https://t.me/vunliem");

        OT0.setText("Prefixes Number");
        OT1.setText("Check number");
        OT2.setText("Check balance");
        OT3.setText("Go to Metfone official website");
        OT4.setText("Contact to customer");

        OT0.setCallbackData("Othersbutton0");
        OT1.setCallbackData("Othersbutton1");
        OT2.setCallbackData("Othersbutton2");
        Othersbutton0.add(OT0);
        Othersbutton0.add(OT1);
        Othersbutton0.add(OT2);
        Othersbutton3.add(OT3);
        Othersbutton4.add(OT4);
        listInlineButton.add(Othersbutton0);
        listInlineButton.add(Othersbutton1);
        listInlineButton.add(Othersbutton2);
        listInlineButton.add(Othersbutton3);
        listInlineButton.add(Othersbutton4);

        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void selectServiceButtons (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Click the button below to choose our Internet plans and services!");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> enbutton1 = new ArrayList<>();
        List<InlineKeyboardButton> enbutton2 = new ArrayList<>();
        List<InlineKeyboardButton> enbutton3 = new ArrayList<>();
        List<InlineKeyboardButton> enbutton4 = new ArrayList<>();
        List<InlineKeyboardButton> enbutton5 = new ArrayList<>();
        List<InlineKeyboardButton> enbutton6 = new ArrayList<>();

        InlineKeyboardButton M1 = new InlineKeyboardButton();
        InlineKeyboardButton M2 = new InlineKeyboardButton();
        InlineKeyboardButton M3 = new InlineKeyboardButton();
        InlineKeyboardButton M4 = new InlineKeyboardButton();
        InlineKeyboardButton M5 = new InlineKeyboardButton();
        InlineKeyboardButton M6 = new InlineKeyboardButton();

        M4.setUrl("https://metfone.com.kh/en/internet/ftth");
        M5.setUrl("https://metfone.com.kh/en/news/career");

        M1.setText("Popular Internet plans and services");
        M2.setText("Mobile Internet services");
        M3.setText("Digital Services");
        M4.setText("Wifi and Internet services");
        M5.setText("Careers");
        M6.setText("Others");
        M1.setCallbackData("enbutton1");
        M2.setCallbackData("enbutton2");
        M3.setCallbackData("enbutton3");
        M4.setCallbackData("enbutton4");
        M5.setCallbackData("enbutton5");
        M6.setCallbackData("enbutton6");
        enbutton1.add(M1);
        enbutton2.add(M2);
        enbutton3.add(M3);
        enbutton4.add(M4);
        enbutton5.add(M5);
        enbutton6.add(M6);
        listInlineButton.add(enbutton1);
        listInlineButton.add(enbutton2);
        listInlineButton.add(enbutton3);
        listInlineButton.add(enbutton4);
        listInlineButton.add(enbutton5);
        listInlineButton.add(enbutton6);

        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void selectInernetPlansAndServices (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Click the button below to choose our services!");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> ButtonMIU0 = new ArrayList<>();
        List<InlineKeyboardButton> ButtonMIU1 = new ArrayList<>();
        List<InlineKeyboardButton> ButtonMIU2 = new ArrayList<>();
        List<InlineKeyboardButton> ButtonMIU3 = new ArrayList<>();
        List<InlineKeyboardButton> ButtonMIU4 = new ArrayList<>();
        List<InlineKeyboardButton> ButtonMIU5 = new ArrayList<>();
        List<InlineKeyboardButton> ButtonMIU6 = new ArrayList<>();
        List<InlineKeyboardButton> ButtonMIU7 = new ArrayList<>();
        List<InlineKeyboardButton> ButtonMIU8 = new ArrayList<>();

        InlineKeyboardButton MIU0 = new InlineKeyboardButton();
        InlineKeyboardButton MIU1 = new InlineKeyboardButton();
        InlineKeyboardButton MIU2 = new InlineKeyboardButton();
        InlineKeyboardButton MIU3 = new InlineKeyboardButton();
        InlineKeyboardButton MIU4 = new InlineKeyboardButton();
        InlineKeyboardButton MIU5 = new InlineKeyboardButton();
        MIU5.setUrl("https://metfone.com.kh/en/guideline-top-up-online");
        InlineKeyboardButton MIU6 = new InlineKeyboardButton();
        MIU6.setUrl("https://metfone.com.kh/en/mobile/mobile-internet/apn-setting");
        InlineKeyboardButton MIU7 = new InlineKeyboardButton();
        MIU7.setUrl("https://metfone.com.kh/en/mobile/mobile-internet/limited-plan/guideline-set-up-4g/guideline-set-up-4g");
        InlineKeyboardButton MIU8 = new InlineKeyboardButton();
        MIU8.setUrl("https://metfone.com.kh/en/hd-voice");

        MIU0.setText("Super Exchange");
        MIU1.setText("Limited Plan");
        MIU2.setText("Social Plan");
        MIU3.setText("Youtube Plan");
        MIU4.setText("Unlimited Plans");
        MIU5.setText("Guideline Top-up Online");
        MIU6.setText("Guideline APN Setting");
        MIU7.setText("Guideline Set Up 4G");
        MIU8.setText("Guideline Set Up 4G VoLTE");

        MIU0.setCallbackData("buttons0");
        MIU1.setCallbackData("buttons1");
        MIU2.setCallbackData("buttons2");
        MIU3.setCallbackData("buttons3");
        MIU4.setCallbackData("buttons4");
        MIU5.setCallbackData("buttons5");
        MIU6.setCallbackData("buttons6");
        MIU7.setCallbackData("buttons7");
        MIU8.setCallbackData("buttons8");
        ButtonMIU0.add(MIU0);
        ButtonMIU0.add(MIU1);
        ButtonMIU2.add(MIU2);
        ButtonMIU2.add(MIU3);
        ButtonMIU4.add(MIU4);
        ButtonMIU4.add(MIU5);
        ButtonMIU6.add(MIU6);
        ButtonMIU6.add(MIU7);
        ButtonMIU8.add(MIU8);
        listInlineButton.add(ButtonMIU0);
        listInlineButton.add(ButtonMIU1);
        listInlineButton.add(ButtonMIU2);
        listInlineButton.add(ButtonMIU3);
        listInlineButton.add(ButtonMIU4);
        listInlineButton.add(ButtonMIU5);
        listInlineButton.add(ButtonMIU6);
        listInlineButton.add(ButtonMIU7);
        listInlineButton.add(ButtonMIU8);

        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void mobileEn (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Click the button below to choose our services");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> mobileEn1 = new ArrayList<>();
        List<InlineKeyboardButton> mobileEn2 = new ArrayList<>();
        List<InlineKeyboardButton> mobileEn3 = new ArrayList<>();
        List<InlineKeyboardButton> mobileEn4 = new ArrayList<>();
        List<InlineKeyboardButton> mobileEn5 = new ArrayList<>();

        InlineKeyboardButton MobileEn1 = new InlineKeyboardButton();
        InlineKeyboardButton MobileEn2 = new InlineKeyboardButton();
        InlineKeyboardButton MobileEn3 = new InlineKeyboardButton();
        InlineKeyboardButton MobileEn4 = new InlineKeyboardButton();
        InlineKeyboardButton MobileEn5 = new InlineKeyboardButton();
        MobileEn4.setUrl("https://metfone.com.kh/en/roaming");
        MobileEn5.setUrl("https://metfone.com.kh/en/mobile/postpaid/postpaid-plan");

        MobileEn1.setText("Promotion");
        MobileEn2.setText("Mobile Internet");
        MobileEn3.setText("Prepaid");
        MobileEn4.setText("International");
        MobileEn5.setText("PostPaid");

        MobileEn1.setCallbackData("mobileEn1");
        MobileEn2.setCallbackData("mobileEn2");
        MobileEn3.setCallbackData("mobileEn3");
        MobileEn4.setCallbackData("mobileEn4");
        MobileEn5.setCallbackData("mobileEn5");

        mobileEn1.add(MobileEn1);
        mobileEn1.add(MobileEn2);
        mobileEn1.add(MobileEn3);
        mobileEn4.add(MobileEn4);
        mobileEn5.add(MobileEn5);

        listInlineButton.add(mobileEn1);
        listInlineButton.add(mobileEn2);
        listInlineButton.add(mobileEn3);
        listInlineButton.add(mobileEn4);
        listInlineButton.add(mobileEn5);

        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
    public void promotionEn (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Click the button below to choose Promotion services");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> promotionEn1 = new ArrayList<>();
        List<InlineKeyboardButton> promotionEn2 = new ArrayList<>();
        List<InlineKeyboardButton> promotionEn3 = new ArrayList<>();
        List<InlineKeyboardButton> promotionEn4 = new ArrayList<>();
        List<InlineKeyboardButton> promotionEn5 = new ArrayList<>();

        InlineKeyboardButton PromotionEn1 = new InlineKeyboardButton();
        InlineKeyboardButton PromotionEn2 = new InlineKeyboardButton();
        InlineKeyboardButton PromotionEn3 = new InlineKeyboardButton();
        InlineKeyboardButton PromotionEn4 = new InlineKeyboardButton();
        PromotionEn4.setUrl("https://metfone.com.kh/en/mobile/promotion/esim/esim");
        InlineKeyboardButton PromotionEn5 = new InlineKeyboardButton();
        PromotionEn5.setUrl("https://metfone.com.kh/en/mpower");

        PromotionEn1.setText("Exchange Plus");
        PromotionEn2.setText("TikTok Unlimited");
        PromotionEn3.setText("Sabay Leng");
        PromotionEn4.setText("eSim");
        PromotionEn5.setText("MPower (This service for chinese only!)");

        PromotionEn1.setCallbackData("promotionEn1");
        PromotionEn2.setCallbackData("promotionEn2");
        PromotionEn3.setCallbackData("promotionEn3");
        PromotionEn4.setCallbackData("promotionEn4");
        PromotionEn5.setCallbackData("promotionEn5");

        promotionEn1.add(PromotionEn1);
        promotionEn1.add(PromotionEn2);
        promotionEn3.add(PromotionEn3);
        promotionEn3.add(PromotionEn4);
        promotionEn5.add(PromotionEn5);

        listInlineButton.add(promotionEn1);
        listInlineButton.add(promotionEn2);
        listInlineButton.add(promotionEn3);
        listInlineButton.add(promotionEn4);
        listInlineButton.add(promotionEn5);

        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void prepaidEn (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Click the button below to choose Prepaid services");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> prepaidEn1 = new ArrayList<>();
        List<InlineKeyboardButton> prepaidEn2 = new ArrayList<>();
        List<InlineKeyboardButton> prepaidEn3 = new ArrayList<>();
        List<InlineKeyboardButton> prepaidEn4 = new ArrayList<>();
        List<InlineKeyboardButton> prepaidEn5 = new ArrayList<>();
        List<InlineKeyboardButton> prepaidEn6 = new ArrayList<>();

        InlineKeyboardButton PrepaidEn1 = new InlineKeyboardButton();
        PrepaidEn1.setUrl("https://metfone.com.kh/en/mobile/prepaid/4-ever");
        InlineKeyboardButton PrepaidEn2 = new InlineKeyboardButton();
        PrepaidEn2.setUrl("https://metfone.com.kh/en/mobile/prepaid/kado80");
        InlineKeyboardButton PrepaidEn3 = new InlineKeyboardButton();
        PrepaidEn3.setUrl("https://metfone.com.kh/en/mobile/prepaid/yak");
        InlineKeyboardButton PrepaidEn4 = new InlineKeyboardButton();
        PrepaidEn4.setUrl("https://metfone.com.kh/en/mobile/prepaid/nop70");
        InlineKeyboardButton PrepaidEn5 = new InlineKeyboardButton();
        PrepaidEn5.setUrl("https://metfone.com.kh/en/mobile/prepaid/top-up");
        InlineKeyboardButton PrepaidEn6 = new InlineKeyboardButton();
        PrepaidEn6.setUrl("https://metfone.com.kh/en/revoking-prepaid-number");

        PrepaidEn1.setText("4EVER");
        PrepaidEn2.setText("Kado80");
        PrepaidEn3.setText("Yak");
        PrepaidEn4.setText("Nop70");
        PrepaidEn5.setText("Top up");
        PrepaidEn6.setText("Revoking Prepaid Number");

        PrepaidEn1.setCallbackData("prepaidEn1");
        PrepaidEn2.setCallbackData("prepaidEn2");
        PrepaidEn3.setCallbackData("prepaidEn3");
        PrepaidEn4.setCallbackData("prepaidEn4");
        PrepaidEn5.setCallbackData("prepaidEn5");
        PrepaidEn6.setCallbackData("prepaidEn6");

        prepaidEn1.add(PrepaidEn1);
        prepaidEn1.add(PrepaidEn2);
        prepaidEn3.add(PrepaidEn3);
        prepaidEn3.add(PrepaidEn4);
        prepaidEn5.add(PrepaidEn5);
        prepaidEn6.add(PrepaidEn6);

        listInlineButton.add(prepaidEn1);
        listInlineButton.add(prepaidEn2);
        listInlineButton.add(prepaidEn3);
        listInlineButton.add(prepaidEn4);
        listInlineButton.add(prepaidEn5);
        listInlineButton.add(prepaidEn6);

        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void digitalServiceEn (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Click the button below to choose our digital services");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> digitalServiceEn1 = new ArrayList<>();
        List<InlineKeyboardButton> digitalServiceEn2 = new ArrayList<>();
        List<InlineKeyboardButton> digitalServiceEn3 = new ArrayList<>();
        List<InlineKeyboardButton> digitalServiceEn4 = new ArrayList<>();
        List<InlineKeyboardButton> digitalServiceEn5 = new ArrayList<>();

        InlineKeyboardButton DigitalServiceEn1 = new InlineKeyboardButton();
        InlineKeyboardButton DigitalServiceEn2 = new InlineKeyboardButton();
        InlineKeyboardButton DigitalServiceEn3 = new InlineKeyboardButton();
        InlineKeyboardButton DigitalServiceEn4 = new InlineKeyboardButton();
        InlineKeyboardButton DigitalServiceEn5 = new InlineKeyboardButton();
        DigitalServiceEn5.setUrl("https://metfone.com.kh/en/emoney/about-emoney");

        DigitalServiceEn1.setText("Music");
        DigitalServiceEn2.setText("Utilities");
        DigitalServiceEn3.setText("Information");
        DigitalServiceEn4.setText("Entertainment");
        DigitalServiceEn5.setText("EMoney");

        DigitalServiceEn1.setCallbackData("digitalServiceEn1");
        DigitalServiceEn2.setCallbackData("digitalServiceEn2");
        DigitalServiceEn3.setCallbackData("digitalServiceEn3");
        DigitalServiceEn4.setCallbackData("digitalServiceEn4");
        DigitalServiceEn5.setCallbackData("digitalServiceEn5");

        digitalServiceEn1.add(DigitalServiceEn1);
        digitalServiceEn1.add(DigitalServiceEn2);
        digitalServiceEn3.add(DigitalServiceEn3);
        digitalServiceEn3.add(DigitalServiceEn4);
        digitalServiceEn4.add(DigitalServiceEn5);

        listInlineButton.add(digitalServiceEn1);
        listInlineButton.add(digitalServiceEn2);
        listInlineButton.add(digitalServiceEn3);
        listInlineButton.add(digitalServiceEn4);
        listInlineButton.add(digitalServiceEn5);

        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void digitalMusicEn (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Click the button below to choose our digital music services");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> digitalMusicEn1 = new ArrayList<>();
        List<InlineKeyboardButton> digitalMusicEn2 = new ArrayList<>();

        InlineKeyboardButton DigitalMusicEn1 = new InlineKeyboardButton();
        DigitalMusicEn1.setUrl("https://metfone.com.kh/en/service/vas/music/music-fan");
        InlineKeyboardButton DigitalMusicEn2 = new InlineKeyboardButton();
        DigitalMusicEn2.setUrl("https://metfone.com.kh/en/service/vas/music/imuzik-3g");

        DigitalMusicEn1.setText("Music Fan");
        DigitalMusicEn2.setText("Imuzik 3G");

        digitalMusicEn1.add(DigitalMusicEn1);
        digitalMusicEn1.add(DigitalMusicEn2);

        listInlineButton.add(digitalMusicEn1);
        listInlineButton.add(digitalMusicEn2);


        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void digitalUtilities (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Click the button below to choose our digital Utilities services");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> digitalUtilitiesEn1 = new ArrayList<>();
        List<InlineKeyboardButton> digitalUtilitiesEn2 = new ArrayList<>();
        List<InlineKeyboardButton> digitalUtilitiesEn3 = new ArrayList<>();
        List<InlineKeyboardButton> digitalUtilitiesEn4 = new ArrayList<>();

        InlineKeyboardButton DigitalUtilitiesEn1 = new InlineKeyboardButton();
        DigitalUtilitiesEn1.setUrl("https://metfone.com.kh/en/service/vas/utilities/i-share");
        InlineKeyboardButton DigitalUtilitiesEn2 = new InlineKeyboardButton();
        DigitalUtilitiesEn2.setUrl("https://metfone.com.kh/en/service/vas/utilities/missed-call-alert");
        InlineKeyboardButton DigitalUtilitiesEn3 = new InlineKeyboardButton();
        DigitalUtilitiesEn3.setUrl("https://metfone.com.kh/en/service/vas/utilities/loan-service");
        InlineKeyboardButton DigitalUtilitiesEn4 = new InlineKeyboardButton();
        DigitalUtilitiesEn4.setUrl("https://metfone.com.kh/en/service/vas/utilities/call-me-back");

        DigitalUtilitiesEn1.setText("I-Share");
        DigitalUtilitiesEn2.setText("Missed Call Alert Service");
        DigitalUtilitiesEn3.setText("Loan Service");
        DigitalUtilitiesEn4.setText("Call me back");

        digitalUtilitiesEn1.add(DigitalUtilitiesEn1);
        digitalUtilitiesEn1.add(DigitalUtilitiesEn2);
        digitalUtilitiesEn2.add(DigitalUtilitiesEn3);
        digitalUtilitiesEn2.add(DigitalUtilitiesEn4);

        listInlineButton.add(digitalUtilitiesEn1);
        listInlineButton.add(digitalUtilitiesEn2);
        listInlineButton.add(digitalUtilitiesEn3);
        listInlineButton.add(digitalUtilitiesEn4);
        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void digitalInformation (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Click the button below to choose Information type!");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> digitalInformationEn1 = new ArrayList<>();
        List<InlineKeyboardButton> digitalInformationEn2 = new ArrayList<>();
        List<InlineKeyboardButton> digitalInformationEn3 = new ArrayList<>();

        InlineKeyboardButton DigitalInformationEn1 = new InlineKeyboardButton();
        DigitalInformationEn1.setUrl("https://metfone.com.kh/en/service/vas/infotainment/bonna-lai-poramean");
        InlineKeyboardButton DigitalInformationEn2 = new InlineKeyboardButton();
        DigitalInformationEn2.setUrl("https://metfone.com.kh/en/service/vas/infotainment/lucky-fone");
        InlineKeyboardButton DigitalInformationEn3 = new InlineKeyboardButton();
        DigitalInformationEn3.setUrl("https://metfone.com.kh/en/service/vas/infotainment/bonna-lai-poramean/horasas");

        DigitalInformationEn1.setText("Bana Lai Poramean");
        DigitalInformationEn2.setText("Lucky Fone Service");
        DigitalInformationEn3.setText("Horasas");

        digitalInformationEn1.add(DigitalInformationEn1);
        digitalInformationEn1.add(DigitalInformationEn2);
        digitalInformationEn2.add(DigitalInformationEn3);

        listInlineButton.add(digitalInformationEn1);
        listInlineButton.add(digitalInformationEn2);
        listInlineButton.add(digitalInformationEn3);
        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void digitalEntertainment (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Click the button below to choose Entertainment type!");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> digitalEntertainmentEn1 = new ArrayList<>();
        List<InlineKeyboardButton> digitalEntertainmentEn2 = new ArrayList<>();
        List<InlineKeyboardButton> digitalEntertainmentEn3 = new ArrayList<>();
        List<InlineKeyboardButton> digitalEntertainmentEn4 = new ArrayList<>();
        List<InlineKeyboardButton> digitalEntertainmentEn5 = new ArrayList<>();
        List<InlineKeyboardButton> digitalEntertainmentEn6 = new ArrayList<>();

        InlineKeyboardButton DigitalEntertainmentEn1 = new InlineKeyboardButton();
        DigitalEntertainmentEn1.setUrl("https://metfone.com.kh/en/mobile-legends-bang-bang");
        InlineKeyboardButton DigitalEntertainmentEn2 = new InlineKeyboardButton();
        DigitalEntertainmentEn2.setUrl("https://metfone.com.kh/en/gacity-game-portal");
        InlineKeyboardButton DigitalEntertainmentEn3 = new InlineKeyboardButton();
        DigitalEntertainmentEn3.setUrl("https://metfone.com.kh/en/camid");
        InlineKeyboardButton DigitalEntertainmentEn4 = new InlineKeyboardButton();
        DigitalEntertainmentEn4.setUrl("https://metfone.com.kh/en/service/vas/entertainment/mobiletv");
        InlineKeyboardButton DigitalEntertainmentEn5 = new InlineKeyboardButton();
        DigitalEntertainmentEn5.setUrl("https://metfone.com.kh/en/service/vas/entertainment/voice-fun-service");
        InlineKeyboardButton DigitalEntertainmentEn6 = new InlineKeyboardButton();
        DigitalEntertainmentEn6.setUrl("https://metfone.com.kh/en/metfone-lucky-6");

        DigitalEntertainmentEn1.setText("Mobile Legend Bang Bang");
        DigitalEntertainmentEn2.setText("Gacity Game portal");
        DigitalEntertainmentEn3.setText("CamID");
        DigitalEntertainmentEn4.setText("MobileTV");
        DigitalEntertainmentEn5.setText("Voice Fun");
        DigitalEntertainmentEn6.setText("Metfone Lucky 6");

        digitalEntertainmentEn1.add(DigitalEntertainmentEn1);
        digitalEntertainmentEn2.add(DigitalEntertainmentEn2);
        digitalEntertainmentEn3.add(DigitalEntertainmentEn3);
        digitalEntertainmentEn3.add(DigitalEntertainmentEn4);
        digitalEntertainmentEn5.add(DigitalEntertainmentEn5);
        digitalEntertainmentEn5.add(DigitalEntertainmentEn6);

        listInlineButton.add(digitalEntertainmentEn1);
        listInlineButton.add(digitalEntertainmentEn2);
        listInlineButton.add(digitalEntertainmentEn3);
        listInlineButton.add(digitalEntertainmentEn4);
        listInlineButton.add(digitalEntertainmentEn5);
        listInlineButton.add(digitalEntertainmentEn6);
        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void selectServiceButtonsKh (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("ចុចលើប៊ូតុងខាងក្រោមដើម្បីគម្រោងអ៊ីនធើណិត និងសេវាកម្មរបស់មិត្តហ្វូន");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> selectServiceButtonsKh1 = new ArrayList<>();
        List<InlineKeyboardButton> selectServiceButtonsKh2 = new ArrayList<>();
        List<InlineKeyboardButton> selectServiceButtonsKh3 = new ArrayList<>();
        List<InlineKeyboardButton> selectServiceButtonsKh4 = new ArrayList<>();
        List<InlineKeyboardButton> selectServiceButtonsKh5 = new ArrayList<>();
        List<InlineKeyboardButton> selectServiceButtonsKh6 = new ArrayList<>();

        InlineKeyboardButton M1 = new InlineKeyboardButton();
        InlineKeyboardButton M2 = new InlineKeyboardButton();
        InlineKeyboardButton M3 = new InlineKeyboardButton();
        InlineKeyboardButton M4 = new InlineKeyboardButton();
        InlineKeyboardButton M5 = new InlineKeyboardButton();
        InlineKeyboardButton M6 = new InlineKeyboardButton();

        M4.setUrl("https://metfone.com.kh/kh/internet/ftth");
        M5.setUrl("https://metfone.com.kh/en/news/career");

        M1.setText("សេវាកម្ម និងគម្រោងអ៊ីនធើណេតពេញនិយម");
        M2.setText("សេវាកម្មអ៊ីនធើណេតចល័ត");
        M3.setText("សេវាកម្មឌីជីថល");
        M4.setText("សេវាកម្មអ៊ីនធើណេត Wifi");
        M5.setText("ឱកាសការងារ");
        M6.setText("សេវាកម្មផ្សេងៗ");
        M1.setCallbackData("selectServiceButtonsKh1");
        M2.setCallbackData("selectServiceButtonsKh2");
        M3.setCallbackData("selectServiceButtonsKh3");
        M4.setCallbackData("selectServiceButtonsKh4");
        M5.setCallbackData("selectServiceButtonsKh5");
        M6.setCallbackData("selectServiceButtonsKh6");
        selectServiceButtonsKh1.add(M1);
        selectServiceButtonsKh2.add(M2);
        selectServiceButtonsKh3.add(M3);
        selectServiceButtonsKh4.add(M4);
        selectServiceButtonsKh5.add(M5);
        selectServiceButtonsKh6.add(M6);
        listInlineButton.add(selectServiceButtonsKh1);
        listInlineButton.add(selectServiceButtonsKh2);
        listInlineButton.add(selectServiceButtonsKh3);
        listInlineButton.add(selectServiceButtonsKh4);
        listInlineButton.add(selectServiceButtonsKh5);
        listInlineButton.add(selectServiceButtonsKh6);

        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void selectInernetPlansAndServicesKhmer (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("សូមចុចលើប៊ូតុងខាងក្រោមដើម្បីជ្រើសរើសគម្រោងអ៊ីនធើណេត និងសេវាកម្មរបស់ពួលយើង!");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> khButtonMIU0 = new ArrayList<>();
        List<InlineKeyboardButton> khButtonMIU1 = new ArrayList<>();
        List<InlineKeyboardButton> khButtonMIU2 = new ArrayList<>();
        List<InlineKeyboardButton> khButtonMIU3 = new ArrayList<>();
        List<InlineKeyboardButton> khButtonMIU4 = new ArrayList<>();
        List<InlineKeyboardButton> khButtonMIU5 = new ArrayList<>();
        List<InlineKeyboardButton> khButtonMIU6 = new ArrayList<>();
        List<InlineKeyboardButton> khButtonMIU7 = new ArrayList<>();
        List<InlineKeyboardButton> khButtonMIU8 = new ArrayList<>();

        InlineKeyboardButton khMIU0 = new InlineKeyboardButton();
        InlineKeyboardButton khMIU1 = new InlineKeyboardButton();
        InlineKeyboardButton khMIU2 = new InlineKeyboardButton();
        InlineKeyboardButton khMIU3 = new InlineKeyboardButton();
        InlineKeyboardButton khMIU4 = new InlineKeyboardButton();
        InlineKeyboardButton khMIU5 = new InlineKeyboardButton();
        khMIU5.setUrl("https://metfone.com.kh/en/guideline-top-up-online");
        InlineKeyboardButton khMIU6 = new InlineKeyboardButton();
        khMIU6.setUrl("https://metfone.com.kh/en/mobile/mobile-internet/apn-setting");
        InlineKeyboardButton khMIU7 = new InlineKeyboardButton();
        khMIU7.setUrl("https://metfone.com.kh/kh/mobile/mobile-internet/%E1%9E%8E%E1%9F%" +
                "82%E1%9E%93%E1%9E%B6%E1%9F%86%E1%9E%96%E1%9E%B8%E1%9E%80%E1%9E%B6%E1%9E%9A%E1%9E%80%E1%" +
                "9F%86%E1%9E%8E%E1%9E%8F%E1%9F%8B%E1%9E%9F%E1%9F%81%E1%9E%9C%E1%9E%B64g/%E1%9E%8E%E1%" +
                "9F%82%E1%9E%93%E1%9E%B6%E1%9F%86%E1%9E%96%E1%9E%B8%E1%9E%80%E1%9E%B6%E1%9E%9A%E1%9E%" +
                "80%E1%9F%86%E1%9E%8E%E1%9E%8F%E1%9F%8B%E1%9E%99%E1%9E%80%E1%9E%9F%E1%9F%81%E1%9E%9C%E1%9E%B64g");
        InlineKeyboardButton khMIU8 = new InlineKeyboardButton();
        khMIU8.setUrl("https://metfone.com.kh/kh/hd-voice");

        khMIU0.setText("គម្រោងប្ដូរលុយ Super Exchange");
        khMIU1.setText("គម្រោងមានដែនកំណត់");
        khMIU2.setText("គម្រោងបណ្តាញសង្គម");
        khMIU3.setText("គម្រោងយូធូបប្រើដោយសេរី");
        khMIU4.setText("គម្រោងប្រើសេរី");
        khMIU5.setText("របៀបបញ្ខូលលុយតាមរយៈ Top-up Online");
        khMIU6.setText("របៀបកំណត់ APN");
        khMIU7.setText("របៀបកំណត់យកសេវា 4G");
        khMIU8.setText("របៀបកំណត់យកសេវា 4G VoLTE");

        khMIU0.setCallbackData("khbuttons0");
        khMIU1.setCallbackData("khbuttons1");
        khMIU2.setCallbackData("khbuttons2");
        khMIU3.setCallbackData("khbuttons3");
        khMIU4.setCallbackData("khbuttons4");
        khMIU5.setCallbackData("khbuttons5");
        khMIU6.setCallbackData("khbuttons6");
        khMIU7.setCallbackData("khbuttons7");
        khMIU8.setCallbackData("khbuttons8");
        khButtonMIU0.add(khMIU0);
        khButtonMIU1.add(khMIU1);
        khButtonMIU2.add(khMIU2);
        khButtonMIU3.add(khMIU3);
        khButtonMIU4.add(khMIU4);
        khButtonMIU5.add(khMIU5);
        khButtonMIU6.add(khMIU6);
        khButtonMIU7.add(khMIU7);
        khButtonMIU8.add(khMIU8);
        listInlineButton.add(khButtonMIU0);
        listInlineButton.add(khButtonMIU1);
        listInlineButton.add(khButtonMIU2);
        listInlineButton.add(khButtonMIU3);
        listInlineButton.add(khButtonMIU4);
        listInlineButton.add(khButtonMIU5);
        listInlineButton.add(khButtonMIU6);
        listInlineButton.add(khButtonMIU7);
        listInlineButton.add(khButtonMIU8);

        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
    public void selectOthersKh (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("ចុចលើប៊ូតុងខាងក្រោមដើម្បីមើលពត៌មានលម្អិត!");

        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> selectOthersKh1 = new ArrayList<>();
        List<InlineKeyboardButton> selectOthersKh2 = new ArrayList<>();
        List<InlineKeyboardButton> selectOthersKh0 = new ArrayList<>();
        List<InlineKeyboardButton> selectOthersKh3 = new ArrayList<>();
        List<InlineKeyboardButton> selectOthersKh4 = new ArrayList<>();

        InlineKeyboardButton SelectOthersKh1 = new InlineKeyboardButton();
        InlineKeyboardButton SelectOthersKh2 = new InlineKeyboardButton();
        InlineKeyboardButton SelectOthersKh0 = new InlineKeyboardButton();
        InlineKeyboardButton SelectOthersKh3 = new InlineKeyboardButton();
        InlineKeyboardButton SelectOthersKh4 = new InlineKeyboardButton();
        SelectOthersKh3.setUrl("https://metfone.com.kh/kh");
        SelectOthersKh4.setUrl("https://t.me/vunliem");

        SelectOthersKh1.setText("ឆែកលេខទូរសព្ទ");
        SelectOthersKh2.setText("ឆែកទឹកប្រាក់ក្នុងគណនី");
        SelectOthersKh0.setText("ក្បាលលេខសំគាល់របស់បណ្ដាញទូរសព្ទចល័តរបស់មិត្តហ្វូន");
        SelectOthersKh3.setText("ចូលទៅកាន់គេហទំព័រផ្លូវការរបស់មិត្តហ្វូន");
        SelectOthersKh4.setText("សន្ទនាជាមួយបុគ្គលិករបស់មិត្តហ្វូន");

        SelectOthersKh1.setCallbackData("selectOthersKh1");
        SelectOthersKh2.setCallbackData("selectOthersKh2");
        SelectOthersKh0.setCallbackData("selectOthersKh0");
        selectOthersKh1.add(SelectOthersKh1);
        selectOthersKh1.add(SelectOthersKh2);
        selectOthersKh0.add(SelectOthersKh0);
        selectOthersKh3.add(SelectOthersKh3);
        selectOthersKh4.add(SelectOthersKh4);
        listInlineButton.add(selectOthersKh1);
        listInlineButton.add(selectOthersKh2);
        listInlineButton.add(selectOthersKh0);
        listInlineButton.add(selectOthersKh3);
        listInlineButton.add(selectOthersKh4);

        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void mobileKh (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("ចុចលើប៉ូតុងខាងក្រោមដើម្បីជ្រើសរើសសេវាកម្មរបស់មិត្តហ្វូន");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> mobileKh1 = new ArrayList<>();
        List<InlineKeyboardButton> mobileKh2 = new ArrayList<>();
        List<InlineKeyboardButton> mobileKh3 = new ArrayList<>();
        List<InlineKeyboardButton> mobileKh4 = new ArrayList<>();
        List<InlineKeyboardButton> mobileKh5 = new ArrayList<>();

        InlineKeyboardButton MobileKh1 = new InlineKeyboardButton();
        InlineKeyboardButton MobileKh2 = new InlineKeyboardButton();
        InlineKeyboardButton MobileKh3 = new InlineKeyboardButton();
        InlineKeyboardButton MobileKh4 = new InlineKeyboardButton();
        InlineKeyboardButton MobileKh5 = new InlineKeyboardButton();
        MobileKh4.setUrl("https://metfone.com.kh/kh/roaming");
        MobileKh5.setUrl("https://metfone.com.kh/kh/mobile/postpaid/gold");

        MobileKh1.setText("ប្រូម៉ូសិន");
        MobileKh2.setText("អ៊ិនធើណិតចល័ត");
        MobileKh3.setText("បង់ប្រាក់ជាមុន");
        MobileKh4.setText("សេវាអន្ដរជាតិ");
        MobileKh5.setText("បង់ប្រាក់ប្រចាំខែ");

        MobileKh1.setCallbackData("mobileKh1");
        MobileKh2.setCallbackData("mobileKh2");
        MobileKh3.setCallbackData("mobileKh3");
        MobileKh4.setCallbackData("mobileKh4");
        MobileKh5.setCallbackData("mobileKh5");

        mobileKh1.add(MobileKh1);
        mobileKh1.add(MobileKh2);
        mobileKh1.add(MobileKh3);
        mobileKh4.add(MobileKh4);
        mobileKh5.add(MobileKh5);

        listInlineButton.add(mobileKh1);
        listInlineButton.add(mobileKh2);
        listInlineButton.add(mobileKh3);
        listInlineButton.add(mobileKh4);
        listInlineButton.add(mobileKh5);

        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
    public void promotionKh (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("ចុចលើប៉ូតុងខាងក្រោមដើម្បីជ្រើសរើសសេវាកម្មរបស់មិត្តហ្វូន");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> promotionKh1 = new ArrayList<>();
        List<InlineKeyboardButton> promotionKh2 = new ArrayList<>();
        List<InlineKeyboardButton> promotionKh3 = new ArrayList<>();
        List<InlineKeyboardButton> promotionKh4 = new ArrayList<>();
        List<InlineKeyboardButton> promotionKh5 = new ArrayList<>();

        InlineKeyboardButton PromotionKh1 = new InlineKeyboardButton();
        InlineKeyboardButton PromotionKh2 = new InlineKeyboardButton();
        InlineKeyboardButton PromotionKh3 = new InlineKeyboardButton();
        InlineKeyboardButton PromotionKh4 = new InlineKeyboardButton();
        PromotionKh4.setUrl("https://metfone.com.kh/kh/mobile/%E1%9E%94%E1" +
                "%9F%92%E1%9E%9A%E1%9E%BC%E1%9E%98%E1%9F%89%E1%9E%BC%E1%9E%9" +
                "F%E1%9E%B7%E1%9E%93/esim/esim");
        InlineKeyboardButton PromotionKh5 = new InlineKeyboardButton();
        PromotionKh5.setUrl("https://metfone.com.kh/kh/mpower");

        PromotionKh1.setText("អ៊ិចឆេងផ្លឹស");
        PromotionKh2.setText("TikTok ឥតដែនកំណត់");
        PromotionKh3.setText("សប្បាយលេង");
        PromotionKh4.setText("eSim");
        PromotionKh5.setText("Mpower (This service for chinese only!)");

        PromotionKh1.setCallbackData("promotionKh1");
        PromotionKh2.setCallbackData("promotionKh2");
        PromotionKh3.setCallbackData("promotionKh3");
        PromotionKh4.setCallbackData("promotionKh4");
        PromotionKh5.setCallbackData("promotionKh5");

        promotionKh1.add(PromotionKh1);
        promotionKh1.add(PromotionKh2);
        promotionKh3.add(PromotionKh3);
        promotionKh3.add(PromotionKh4);
        promotionKh5.add(PromotionKh5);

        listInlineButton.add(promotionKh1);
        listInlineButton.add(promotionKh2);
        listInlineButton.add(promotionKh3);
        listInlineButton.add(promotionKh4);
        listInlineButton.add(promotionKh5);

        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void prepaidKh (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("ចុចលើប៉ូតុងខាងក្រោមដើម្បីជ្រើសរើសសេវាកម្មរបស់មិត្តហ្វូន");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> prepaidKh1 = new ArrayList<>();
        List<InlineKeyboardButton> prepaidKh2 = new ArrayList<>();
        List<InlineKeyboardButton> prepaidKh3 = new ArrayList<>();
        List<InlineKeyboardButton> prepaidKh4 = new ArrayList<>();
        List<InlineKeyboardButton> prepaidKh5 = new ArrayList<>();
        List<InlineKeyboardButton> prepaidKh6 = new ArrayList<>();

        InlineKeyboardButton PrepaidKh1 = new InlineKeyboardButton();
        PrepaidKh1.setUrl("https://metfone.com.kh/kh/mobile/prepaid/4-ever");
        InlineKeyboardButton PrepaidKh2 = new InlineKeyboardButton();
        PrepaidKh2.setUrl("https://metfone.com.kh/kh/mobile/prepaid/kado80");
        InlineKeyboardButton PrepaidKh3 = new InlineKeyboardButton();
        PrepaidKh3.setUrl("https://metfone.com.kh/kh/mobile/prepaid/yak");
        InlineKeyboardButton PrepaidKh4 = new InlineKeyboardButton();
        PrepaidKh4.setUrl("https://metfone.com.kh/kh/mobile/prepaid/nop70");
        InlineKeyboardButton PrepaidKh5 = new InlineKeyboardButton();
        PrepaidKh5.setUrl("https://metfone.com.kh/kh/mobile/prepaid/top-up");
        InlineKeyboardButton PrepaidKh6 = new InlineKeyboardButton();
        PrepaidKh6.setUrl("https://metfone.com.kh/kh/revoking-prepaid-number");

        PrepaidKh1.setText("4EVER");
        PrepaidKh2.setText("Kado80");
        PrepaidKh3.setText("Yak");
        PrepaidKh4.setText("Nop70");
        PrepaidKh5.setText("បញ្ចូលលុយ");
        PrepaidKh6.setText("ការដកហូតលេខដែលបង់ប្រាក់មុន");

        PrepaidKh1.setCallbackData("prepaidKh1");
        PrepaidKh2.setCallbackData("prepaidKh2");
        PrepaidKh3.setCallbackData("prepaidKh3");
        PrepaidKh4.setCallbackData("prepaidKh4");
        PrepaidKh5.setCallbackData("prepaidKh5");
        PrepaidKh6.setCallbackData("prepaidKh6");

        prepaidKh1.add(PrepaidKh1);
        prepaidKh1.add(PrepaidKh2);
        prepaidKh3.add(PrepaidKh3);
        prepaidKh3.add(PrepaidKh4);
        prepaidKh5.add(PrepaidKh5);
        prepaidKh6.add(PrepaidKh6);

        listInlineButton.add(prepaidKh1);
        listInlineButton.add(prepaidKh2);
        listInlineButton.add(prepaidKh3);
        listInlineButton.add(prepaidKh4);
        listInlineButton.add(prepaidKh5);
        listInlineButton.add(prepaidKh6);

        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void digitalServiceKh (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("ចុចលើប៉ូតុងខាងក្រោមដើម្បីជ្រើសរើសសេវាកម្មរបស់មិត្តហ្វូន");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> digitalServiceKh1 = new ArrayList<>();
        List<InlineKeyboardButton> digitalServiceKh2 = new ArrayList<>();
        List<InlineKeyboardButton> digitalServiceKh3 = new ArrayList<>();
        List<InlineKeyboardButton> digitalServiceKh4 = new ArrayList<>();
        List<InlineKeyboardButton> digitalServiceKh5 = new ArrayList<>();

        InlineKeyboardButton DigitalServiceKh1 = new InlineKeyboardButton();
        InlineKeyboardButton DigitalServiceKh2 = new InlineKeyboardButton();
        InlineKeyboardButton DigitalServiceKh3 = new InlineKeyboardButton();
        InlineKeyboardButton DigitalServiceKh4 = new InlineKeyboardButton();
        InlineKeyboardButton DigitalServiceKh5 = new InlineKeyboardButton();
        DigitalServiceKh5.setUrl("https://metfone.com.kh/kh/emoney/about-emoney");

        DigitalServiceKh1.setText("តន្រ្តី");
        DigitalServiceKh2.setText("សេវាកម្មផ្សេងៗ");
        DigitalServiceKh3.setText("ព័ត៌មានបន្ថែម");
        DigitalServiceKh4.setText("ការកំសាន្ត");
        DigitalServiceKh5.setText("អ៊ី-ម៉ាន់នី");

        DigitalServiceKh1.setCallbackData("digitalServiceKh1");
        DigitalServiceKh2.setCallbackData("digitalServiceKh2");
        DigitalServiceKh3.setCallbackData("digitalServiceKh3");
        DigitalServiceKh4.setCallbackData("digitalServiceKh4");
        DigitalServiceKh5.setCallbackData("digitalServiceKh5");

        digitalServiceKh1.add(DigitalServiceKh1);
        digitalServiceKh1.add(DigitalServiceKh2);
        digitalServiceKh3.add(DigitalServiceKh3);
        digitalServiceKh3.add(DigitalServiceKh4);
        digitalServiceKh4.add(DigitalServiceKh5);

        listInlineButton.add(digitalServiceKh1);
        listInlineButton.add(digitalServiceKh2);
        listInlineButton.add(digitalServiceKh3);
        listInlineButton.add(digitalServiceKh4);
        listInlineButton.add(digitalServiceKh5);

        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void digitalMusicKh (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("ចុចលើប៉ូតុងខាងក្រោមដើម្បីជ្រើសរើសសេវាកម្មរបស់មិត្តហ្វូន");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> digitalMusicKh1 = new ArrayList<>();
        List<InlineKeyboardButton> digitalMusicKh2 = new ArrayList<>();

        InlineKeyboardButton DigitalMusicKh1 = new InlineKeyboardButton();
        DigitalMusicKh1.setUrl("https://metfone.com.kh/kh/service/vas/music/music-fan");
        InlineKeyboardButton DigitalMusicKh2 = new InlineKeyboardButton();
        DigitalMusicKh2.setUrl("https://metfone.com.kh/kh/service/vas/music/imuzik3g");

        DigitalMusicKh1.setText("Music Fan");
        DigitalMusicKh2.setText("Imuzik 3G");

        digitalMusicKh1.add(DigitalMusicKh1);
        digitalMusicKh1.add(DigitalMusicKh2);

        listInlineButton.add(digitalMusicKh1);
        listInlineButton.add(digitalMusicKh2);


        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void digitalUtilitiesKh (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("ចុចលើប៉ូតុងខាងក្រោមដើម្បីជ្រើសរើសសេវាកម្មរបស់មិត្តហ្វូន");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> digitalUtilitiesKh1 = new ArrayList<>();
        List<InlineKeyboardButton> digitalUtilitiesKh2 = new ArrayList<>();
        List<InlineKeyboardButton> digitalUtilitiesKh3 = new ArrayList<>();
        List<InlineKeyboardButton> digitalUtilitiesKh4 = new ArrayList<>();

        InlineKeyboardButton DigitalUtilitiesKh1 = new InlineKeyboardButton();
        DigitalUtilitiesKh1.setUrl("https://metfone.com.kh/kh/service/vas/utilities/i-share");
        InlineKeyboardButton DigitalUtilitiesKh2 = new InlineKeyboardButton();
        DigitalUtilitiesKh2.setUrl("https://metfone.com.kh/kh/service/vas/utilities/missed-call-alert");
        InlineKeyboardButton DigitalUtilitiesKh3 = new InlineKeyboardButton();
        DigitalUtilitiesKh3.setUrl("https://metfone.com.kh/kh/service/vas/utilities/loan-service");
        InlineKeyboardButton DigitalUtilitiesKh4 = new InlineKeyboardButton();
        DigitalUtilitiesKh4.setUrl("https://metfone.com.kh/kh/service/vas/utilities/call-me-back");

        DigitalUtilitiesKh1.setText("I-Share");
        DigitalUtilitiesKh2.setText("Missed Call Alert Service");
        DigitalUtilitiesKh3.setText("សេវាកម្មកម្ចីលុយ");
        DigitalUtilitiesKh4.setText("Call me back");

        digitalUtilitiesKh1.add(DigitalUtilitiesKh1);
        digitalUtilitiesKh1.add(DigitalUtilitiesKh2);
        digitalUtilitiesKh2.add(DigitalUtilitiesKh3);
        digitalUtilitiesKh2.add(DigitalUtilitiesKh4);

        listInlineButton.add(digitalUtilitiesKh1);
        listInlineButton.add(digitalUtilitiesKh2);
        listInlineButton.add(digitalUtilitiesKh3);
        listInlineButton.add(digitalUtilitiesKh4);
        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void digitalInformationKh (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("ចុចលើប៉ូតុងខាងក្រោមដើម្បីជ្រើសរើសសេវាកម្មរបស់មិត្តហ្វូន");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> digitalInformationKh1 = new ArrayList<>();
        List<InlineKeyboardButton> digitalInformationKh2 = new ArrayList<>();
        List<InlineKeyboardButton> digitalInformationKh3 = new ArrayList<>();

        InlineKeyboardButton DigitalInformationKh1 = new InlineKeyboardButton();
        DigitalInformationKh1.setUrl("https://metfone.com.kh/kh/service/vas/infotainment/bonna-lai-poramean");
        InlineKeyboardButton DigitalInformationKh2 = new InlineKeyboardButton();
        DigitalInformationKh2.setUrl("https://metfone.com.kh/kh/service/vas/infotainment/lucky-fone");
        InlineKeyboardButton DigitalInformationKh3 = new InlineKeyboardButton();
        DigitalInformationKh3.setUrl("https://metfone.com.kh/kh/service/vas/infotainment/horasas");

        DigitalInformationKh1.setText("បណ្ណាល័យព័ត៌មាន");
        DigitalInformationKh2.setText("Lucky Fone Service");
        DigitalInformationKh3.setText("Horasas");

        digitalInformationKh1.add(DigitalInformationKh1);
        digitalInformationKh1.add(DigitalInformationKh2);
        digitalInformationKh2.add(DigitalInformationKh3);

        listInlineButton.add(digitalInformationKh1);
        listInlineButton.add(digitalInformationKh2);
        listInlineButton.add(digitalInformationKh3);
        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void digitalEntertainmentKh (String chat_id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("ចុចលើប៉ូតុងខាងក្រោមដើម្បីជ្រើសរើសសេវាកម្មរបស់មិត្តហ្វូន");
        sendMessage.setChatId(chat_id);
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> listInlineButton = new ArrayList<>();

        List<InlineKeyboardButton> digitalEntertainmentKh1 = new ArrayList<>();
        List<InlineKeyboardButton> digitalEntertainmentKh2 = new ArrayList<>();
        List<InlineKeyboardButton> digitalEntertainmentKh3 = new ArrayList<>();
        List<InlineKeyboardButton> digitalEntertainmentKh4 = new ArrayList<>();
        List<InlineKeyboardButton> digitalEntertainmentKh5 = new ArrayList<>();
        //List<InlineKeyboardButton> digitalEntertainmentKh6 = new ArrayList<>();

        InlineKeyboardButton DigitalEntertainmentKh1 = new InlineKeyboardButton();
        DigitalEntertainmentKh1.setUrl("https://metfone.com.kh/kh/mobile-legend-bang-bang");
        InlineKeyboardButton DigitalEntertainmentKh2 = new InlineKeyboardButton();
        DigitalEntertainmentKh2.setUrl("https://metfone.com.kh/kh/service/vas/gacity-game-portal");
        InlineKeyboardButton DigitalEntertainmentKh3 = new InlineKeyboardButton();
        DigitalEntertainmentKh3.setUrl("https://metfone.com.kh/kh/camid");
        InlineKeyboardButton DigitalEntertainmentKh4 = new InlineKeyboardButton();
        DigitalEntertainmentKh4.setUrl("https://metfone.com.kh/kh/service/vas/entertainment/mobiletv");
        InlineKeyboardButton DigitalEntertainmentKh5 = new InlineKeyboardButton();
        DigitalEntertainmentKh5.setUrl("https://metfone.com.kh/kh/service/vas/entertainment/voice-fun-service");
        //InlineKeyboardButton DigitalEntertainmentKh6 = new InlineKeyboardButton();
        //DigitalEntertainmentKh6.setUrl("https://metfone.com.kh/en/metfone-lucky-6");

        DigitalEntertainmentKh1.setText("Mobile Legend Bang Bang");
        DigitalEntertainmentKh2.setText("Gacity Game portal");
        DigitalEntertainmentKh3.setText("CamID");
        DigitalEntertainmentKh4.setText("MobileTV");
        DigitalEntertainmentKh5.setText("Voice Fun");
        //DigitalEntertainmentKh6.setText("Metfone Lucky 6");

        digitalEntertainmentKh1.add(DigitalEntertainmentKh1);
        digitalEntertainmentKh2.add(DigitalEntertainmentKh2);
        digitalEntertainmentKh3.add(DigitalEntertainmentKh3);
        digitalEntertainmentKh3.add(DigitalEntertainmentKh4);
        digitalEntertainmentKh5.add(DigitalEntertainmentKh5);


        listInlineButton.add(digitalEntertainmentKh1);
        listInlineButton.add(digitalEntertainmentKh2);
        listInlineButton.add(digitalEntertainmentKh3);
        listInlineButton.add(digitalEntertainmentKh4);
        listInlineButton.add(digitalEntertainmentKh5);
        //listInlineButton.add(digitalEntertainmentKh6);
        inlineKeyboardMarkup.setKeyboard(listInlineButton);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getBotUsername() {
        return TelebotConfig.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return TelebotConfig.BOT_TOKEN;
    }
}