package org.some.thing.card.regular.controller;

import lombok.RequiredArgsConstructor;
import org.some.thing.card.entity.UserData;
import org.some.thing.card.regular.entity.RegularCard;
import org.some.thing.card.regular.service.RegularService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RegularController {
  private final RegularService regularService;


  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<RegularCard> loadRegular(@RequestHeader("userId") String userId,
                                       @RequestParam("currentDate") Long currentDate) {
    return regularService.loadRegular(UserData.builder()
        .currentDate(currentDate)
        .userId(userId)
        .build());
  }
}