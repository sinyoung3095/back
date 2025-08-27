package com.example.rebound.service;

import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class SmsService {
    //    코드 생성
    private String createCode(){
        String codes = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String code = "";
        Random random = new Random();

        for(int i=0; i<6; i++){
            code += codes.charAt(random.nextInt(codes.length()));
        }

        return code;
    }

    //    문자 발송
    public SingleMessageSentResponse sendOne(SingleMessageSendingRequest singleMessageSendingRequest) {
        String code = createCode();

        DefaultMessageService messageService =  NurigoApp.INSTANCE.initialize("NCSUUCWS4CL3Q8AZ", "IC206OKQZUXLNSVSPAAGBSOZARN7KDEV", "https://api.solapi.com");
        // Message 패키지가 중복될 경우 net.nurigo.sdk.message.model.Message로 치환하여 주세요
        Message message = new Message();
        message.setFrom("01055767406");
        message.setTo("");
        message.setText("인증번호 : " + code);

        System.out.println(message);

        try {
            // send 메소드로 ArrayList<Message> 객체를 넣어도 동작합니다!
            messageService.send(message);
        } catch (NurigoMessageNotReceivedException exception) {
            // 발송에 실패한 메시지 목록을 확인할 수 있습니다!
            System.out.println(exception.getFailedMessageList());
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
