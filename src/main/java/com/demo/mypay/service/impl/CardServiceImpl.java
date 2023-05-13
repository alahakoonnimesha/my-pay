package com.demo.mypay.service.impl;

import com.demo.mypay.api.dto.CardDto;
import com.demo.mypay.api.dto.ResponseDto;
import com.demo.mypay.businessService.CardBusinessService;
import com.demo.mypay.businessService.UserBusinessService;
import com.demo.mypay.businessService.converter.CardConverter;
import com.demo.mypay.domain.Card;
import com.demo.mypay.domain.User;
import com.demo.mypay.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardBusinessService cardBusinessService;
    private final CardConverter cardConverter;
    private final UserBusinessService userBusinessService;

    @Override
    public ResponseDto get(String id) {
        String[] participantsList = new String[]{"Michael Jackson 10 10 10", "Fred Astaire 9 9 9", " Anna Pavlova 9 9 10",};
        double[] average = new double[participantsList.length];
        java.util.Map<String, Integer> averages = new java.util.LinkedHashMap<String, Integer>();
        for (int i = 0; i < participantsList.length; i++) {
            String participant = participantsList[i];
            String[] words = participant.trim().split("\\W+");
            int sumOfScores = 0;
            int numberOfScores = 0;
            StringBuffer participantName = new StringBuffer();
            for (String word : words) {
                try {
                    sumOfScores += Integer.parseInt(word);
                    numberOfScores++;
                } catch (NumberFormatException ex) {
                    participantName.append(word).append(" ");
                }
            }
            averages.put(participantName.toString(), sumOfScores / numberOfScores);
        }
        java.util.Map<String, Integer> sortedAverages = averages.entrySet().stream()
                .sorted(java.util.Map.Entry.<String, Integer>comparingByValue())
                .collect(java.util.stream.Collectors.toMap(java.util.Map.Entry::getKey, java.util.Map.Entry::getValue, (x, y) -> y, java.util.LinkedHashMap::new));


        java.util.Iterator it = sortedAverages.entrySet().iterator();
        int i = 0;
        String[] winners = new String[3];

        while (it.hasNext() && (i < 3)) {
            int previousScore = 0;
            java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
            winners[i] = entry.getKey().toString();
            previousScore = (int) entry.getValue();
            i++;
        }

        StringBuilder sbWinners = new StringBuilder();
        sbWinners.append("The 1st place:").append(winners[0]).
                append(";The 2nd place:").append(winners[1]).
                append(";The 3rd place:").append(winners[2]).
                append(";");
        sbWinners.toString();

        CardDto cardDto = cardConverter.convert(cardBusinessService.get(id));
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(cardDto);
        return responseDto;
    }

    @Override
    @Transactional
    public ResponseDto create(CardDto cardDto) {
        User user = userBusinessService.get(cardDto.getUserId());
        Card card = cardConverter.convert(cardDto);
        card.setUser(user);
        cardBusinessService.create(card);

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Card Created");
        return responseDto;
    }

    @Override
    public ResponseDto update(CardDto cardDto) {
        return null;
    }

}
