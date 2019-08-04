package com.github.joostvdg.cmg.seafarers.model.game;

import java.util.ArrayList;
import java.util.List;

public abstract class Scenarios {

  // LEGEND
  //  GOLD("Gold", Resource.ANY),           // a
  //  DESERT("Desert", Resource.DESERT),    // b
  //  FIELD("Field", Resource.GRAIN),       // c
  //  FOREST("Forest", Resource.LUMBER),    // d
  //  PASTURE("Pasture", Resource.WOOL),    // e
  //  MOUNTAINS("Mountains", Resource.ORE), // f
  //  HILLS("Hills", Resource.BRICK),       // g
  //  SEA("Sea", Resource.SEA);             // h

  //  TWO(2, 27),   // z
  //  THREE(3, 55), // y
  //  FOUR(4, 83),  // x
  //  FIVE(5, 111), // w
  //  SIX(6, 139),  // v
  //  EIGHT(8, 139),// u
  //  NINE(9, 111), // t
  //  TEN(10, 83),  // s
  //  ELEVEN(11, 55)// r
  //  TWELVE(12, 27)// q
  //  // p - meaning, no tile

  public static final List<Scenario> SCENARIOS;

  static {
    SCENARIOS = new ArrayList<>();
    SCENARIOS.add(
            new Scenario.Builder()
                    .name("2008 Six Island (5-6P-Large)")
                    .author("999 Games")
                    .description(
                            "Large Scenario from 999 games for 2008 German edition. Described by Kelvin Chung.")
                    .code("hphpgrdthpduewgwcteqcqhpfsfvhphpfxhphphphphpeyhpcwhpfrezeudxdvfyhpgshpdshphphphphpgwhphpftguhpcyczdwdxevethpgscvhphp")
                    .build());
    SCENARIOS.add(
        new Scenario.Builder()
            .name("2008 Two Island (4P-Normal)")
            .author("999 Games")
            .description(
                "Standard Scenario from 999 games for 2008 German edition. Described by Kelvin Chung.")
            .code(
                "hpgvhpfycqhpcudsewfuexgrhpdzbpdvergtcyhpfscrfxhpeuethphpdwhpaxhphpgwcvhpdthpgyasfzhphphp")
            .build());
    SCENARIOS.add(
        new Scenario.Builder()
            .name("2008 Four Island (4P-Small)")
            .author("999 Games")
            .description(
                "Standard Scenario from 999 games for 2008 German edition. Described by Kelvin Chung.")
            .code("hpgxcwcvhpgsesetdyeufxhphpcrhphphpgzdvfyhphpgwdthphpcqcxdtfsdrfuhpewerhphp")
            .build());
    SCENARIOS.add(
        new Scenario.Builder()
            .name("2008 Four Island (4P-Normal)")
            .author("999 Games")
            .description(
                "Standard Scenario from 999 games for 2008 German edition. Described by Kelvin Chung.")
            .code(
                "hphpdqdthpdvexhpeteycshpfsfuhpgrfxhphphphphphphphphphpbpgzbpfwguhpcyctcwhpeverhpgscxhphp")
            .build());

    //    SCENARIOS.add(new Scenario.Builder()
    //            .name("").author("").description("")
    //            .code("")
    //            .build());
  }
}
