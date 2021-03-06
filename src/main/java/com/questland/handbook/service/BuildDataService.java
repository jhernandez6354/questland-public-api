package com.questland.handbook.service;

import static com.questland.handbook.publicmodel.Build.BLUE_BATTLE_EVENT;
import static com.questland.handbook.publicmodel.Build.BLUE_GUILD_STRIKER;
import static com.questland.handbook.publicmodel.Build.BOOMING_TURTLE;
import static com.questland.handbook.publicmodel.Build.FIRE_BLASTER;
import static com.questland.handbook.publicmodel.Build.HECATOMBUS;
import static com.questland.handbook.publicmodel.Build.ICY_CANNON;
import static com.questland.handbook.publicmodel.Build.RATCHET_RUSH;
import static com.questland.handbook.publicmodel.Build.RED_BATTLE_EVENT;
import static com.questland.handbook.publicmodel.Build.RED_GUILD_STRIKER;
import static com.questland.handbook.publicmodel.Build.SHINOBI;
import static com.questland.handbook.publicmodel.Build.THE_FARMER;
import static com.questland.handbook.publicmodel.Build.THE_PAX;
import static com.questland.handbook.publicmodel.Build.TURTLE;
import static com.questland.handbook.publicmodel.Build.WARDING_FANG;

import com.questland.handbook.publicmodel.Build;
import com.questland.handbook.publicmodel.DisplayableBuild;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class BuildDataService {

  private final List<DisplayableBuild> buildList;
  private final String RED_HOARDER_MAIN_HAND = "Hecatombus";
  private final String RED_HOARDER_MAIN_HAND_BACKUP = "Red Hoarder: None";
  private final String SUPPORT_FOR_DESTROYERS_OFF_HAND = "ThunderClap";
  private final String SUPPORT_FOR_DESTROYERS_OFF_HAND_BACKUP =
      "Support for Destroyers: Azazel Shield, Green Crystal Shield, Nightmare Throne Shield, Bone Driller, Sacrosanctus Ward";
  private final String GRANNY_BROTH_MAIN_HAND = "Malachite Truncheon";
  private final String GRANNY_BROTH_MAIN_HAND_BACKUP = "Granny's Blue Broth: The Hulk, Dracarion";
  private final String MIGHT_MAGIC_OFF_HAND = "Winged Defender Shield";
  private final String MIGHT_MAGIC_OFF_HAND_BACKUP =
      "Mighty Magic: Depth of Despair, Thunderbash, Shadow Owl, Hunger of the Dead";
  private final String YOUR_HEAL_MY_GAIN_OFF_HAND = "The Lost Helm";
  private final String YOUR_HEAL_MY_GAIN_OFF_HAND_BACKUP =
      "Your Heal My Gain: Windwolf Shield, Forest Fury Shield, Forbidden Ritual Shield, Iron Roar";

  public BuildDataService() {
    buildList = getBuilds();
  }

  public Optional<DisplayableBuild> getBuildByApiName(Build build) {
    return buildList.stream()
        .filter(displayableBuild -> displayableBuild.getBuild() == build)
        .findFirst();
  }

  private List<DisplayableBuild> getBuilds() {
    return Stream.of(getCampaignBuilds(), getBattleEventBuilds(), getArenaBuilds())
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  private List<DisplayableBuild> getBattleEventBuilds() {
    return List.of(
        DisplayableBuild.builder()
            .build(RED_BATTLE_EVENT)
            .name("Red Battle Event Setup")
            .description(
                "You use Crest Guardian at lower boss levels for more reliable spirit regen, but if the boss has an anti-healing ability or your armor isn't lasting swap to Elevation. If the boss doesn't have anti-healing use 4% shield recovery otherwise use 15% attack.")
            .weapons(RED_HOARDER_MAIN_HAND + ", " + SUPPORT_FOR_DESTROYERS_OFF_HAND)
            .mainHandAlternatives(RED_HOARDER_MAIN_HAND_BACKUP)
            .offHandAlternatives(SUPPORT_FOR_DESTROYERS_OFF_HAND_BACKUP)
            .talent1("Bloodlust")
            .talent2("Transcendental Tornado")
            .talent3("Crest Guardian / Elevation")
            .links("4% shield recovery / 15% damage, 10% magic resistance")
            .videoGuide("https://www.youtube.com/watch?v=fUVwTqMeVmI")
            .image("https://questland-public-api.cfapps.io/red-be.png")
            .build(),
        DisplayableBuild.builder()
            .build(BLUE_BATTLE_EVENT)
            .name("Blue Battle Event Setup")
            .description(
                "You change your talent based on your passive. For no passive use Crest Guardian, for passive#1 use Sacred Rage, for passive#2 use Mystical Wind.")
            .weapons(GRANNY_BROTH_MAIN_HAND + ", " + MIGHT_MAGIC_OFF_HAND)
            .mainHandAlternatives(GRANNY_BROTH_MAIN_HAND_BACKUP)
            .offHandAlternatives(MIGHT_MAGIC_OFF_HAND_BACKUP)
            .talent1("Inner Fire")
            .talent2("Chilling Cold")
            .talent3("Crest Guardian / Sacred Rage / Mystical Wind")
            .links("4% healing, 10% magic resistance")
            .videoGuide("https://www.youtube.com/watch?v=5zeUF_KstQg")
            .image("https://questland-public-api.cfapps.io/blue-be.png")
            .build(),
        DisplayableBuild.builder()
            .build(RED_GUILD_STRIKER)
            .name("Red Guild Boss Striker")
            .description(
                "No passive use crest guardian, passive#1 sacred rage, and passive#2 Runic Touch. Sin Crusher is the tier 1 weapon here because of it's incredible magic resistance passive. Make sure you are counting the turns to deal with definitely dead. You will need to make sure you can 4R at least 2-3 times in a row to fully heal up.")
            .weapons(RED_HOARDER_MAIN_HAND + ", Sin Crusher")
            .mainHandAlternatives(RED_HOARDER_MAIN_HAND_BACKUP)
            .offHandAlternatives(
                "Second Chance: Triumphant Defender, Battle Beetle, The Scaleward, Arachnea's Heart, Redeemer, Frost Empress, Burden of Betrayal")
            .talent1("Bloodlust")
            .talent2("Transcendental Tornado")
            .talent3("Crest Guardian / sacred rage / Runic Touch")
            .links("15% damage, 10% magic resistance")
            .videoGuide("https://youtu.be/Pf-C_H8xyEY")
            .image("https://questland-public-api.cfapps.io/red-guild-striker.png")
            .build(),
        DisplayableBuild.builder()
            .build(BLUE_GUILD_STRIKER)
            .name("Blue Guild Boss Striker")
            .description(
                "You change your talent based on your passive. For no passive use Crest Guardian, for passive#1 use Sacred Rage, for passive#2 use Mystical Wind.")
            .weapons(GRANNY_BROTH_MAIN_HAND + ", " + MIGHT_MAGIC_OFF_HAND)
            .mainHandAlternatives(GRANNY_BROTH_MAIN_HAND_BACKUP)
            .offHandAlternatives(MIGHT_MAGIC_OFF_HAND_BACKUP)
            .talent1("Inner Fire")
            .talent2("Chilling Cold")
            .talent3("Crest Guardian / Sacred Rage / Mystical Wind")
            .links("4% healing, 10% magic resistance")
            .videoGuide("https://youtu.be/7fXR7Z3MiOM")
            .image("https://questland-public-api.cfapps.io/blue-guild-striker.png")
            .build()
    );
  }

  private List<DisplayableBuild> getCampaignBuilds() {
    return List.of(
        DisplayableBuild.builder()
            .build(HECATOMBUS)
            .name("The Hecatombus")
            .weapons(RED_HOARDER_MAIN_HAND + ", " + SUPPORT_FOR_DESTROYERS_OFF_HAND)
            .mainHandAlternatives(RED_HOARDER_MAIN_HAND_BACKUP)
            .offHandAlternatives(SUPPORT_FOR_DESTROYERS_OFF_HAND_BACKUP)
            .talent1("Bloodlust")
            .talent2("Transcendental Tornado")
            .talent3("Crest Guardian")
            .videoGuide("https://www.youtube.com/watch?v=wu-9ES9aAZg")
            .image("https://questland-public-api.cfapps.io/hecatombus.png")
            .build(),
        DisplayableBuild.builder()
            .build(TURTLE)
            .name("The Turtle")
            .weapons(GRANNY_BROTH_MAIN_HAND + ", " + MIGHT_MAGIC_OFF_HAND)
            .mainHandAlternatives(GRANNY_BROTH_MAIN_HAND_BACKUP)
            .offHandAlternatives(MIGHT_MAGIC_OFF_HAND_BACKUP)
            .talent1("Inner Fire")
            .talent2("Chilling Cold")
            .talent3("Magic Thief")
            .videoGuide("https://www.youtube.com/watch?v=cKGmy0tpDCo")
            .image("https://questland-public-api.cfapps.io/turtle.png")
            .build(),
        DisplayableBuild.builder()
            .build(THE_PAX)
            .name("The Pax")
            .weapons("The Pax, " + MIGHT_MAGIC_OFF_HAND)
            .mainHandAlternatives("Azure Gift: Fang of Naga")
            .offHandAlternatives(
                "Mighty Magic: Depth of Despair, Thunderbash, Shadow Owl, Hunger of the Dead")
            .talent1("Fist of Frenzy")
            .talent2("Faerie Flame")
            .talent3("Magic Thief")
            .videoGuide("https://www.youtube.com/watch?v=3VZ55-NCUlo")
            .image("https://questland-public-api.cfapps.io/pax.png")
            .build(),
        DisplayableBuild.builder()
            .build(SHINOBI)
            .name("Shinobi")
            .description(
                "This build is incredible for clearing Campaign levels with tons of melee enemies or really dodge happy opponents. If your shield isn't breaking fast enough remove your defense orbs and collections.")
            .weapons(RED_HOARDER_MAIN_HAND + ", " + SUPPORT_FOR_DESTROYERS_OFF_HAND)
            .mainHandAlternatives(RED_HOARDER_MAIN_HAND_BACKUP)
            .offHandAlternatives(SUPPORT_FOR_DESTROYERS_OFF_HAND_BACKUP)
            .talent1("Assassin's Way")
            .talent2("Divine Force")
            .talent3("Crest Guardian")
            .videoGuide("https://youtu.be/tRp6RgmFjOI")
            .image("https://questland-public-api.cfapps.io/shinobi.png")
            .build(),
        DisplayableBuild.builder()
            .build(RATCHET_RUSH)
            .name("Ratchet Rush")
            .weapons("Ratchet Hatchet, " + SUPPORT_FOR_DESTROYERS_OFF_HAND)
            .mainHandAlternatives("Red Blast & Blue Twist: The Last Wish")
            .offHandAlternatives(SUPPORT_FOR_DESTROYERS_OFF_HAND_BACKUP)
            .talent1("Inner Fire")
            .talent2("Faerie Flame")
            .talent3("Elevation")
            .videoGuide("https://www.youtube.com/watch?v=EnMpxvYR7L8")
            .image("https://questland-public-api.cfapps.io/ratchet-rush.png")
            .build()
    );
  }

  private List<DisplayableBuild> getArenaBuilds() {
    return List.of(
        DisplayableBuild.builder()
            .build(BOOMING_TURTLE)
            .name("Booming Turtle")
            .weapons("Booming Blade, " + MIGHT_MAGIC_OFF_HAND)
            .mainHandAlternatives(
                "Weaker Body Stronger Magic: Demon's Dame, Black Prophet, Heart of the Iceberg")
            .offHandAlternatives(MIGHT_MAGIC_OFF_HAND_BACKUP)
            .talent1("Bloodlust")
            .talent2("Chilling Cold")
            .talent3("Sacred Rage")
            .videoGuide("https://www.youtube.com/watch?v=Au-g0_nF8ng")
            .image("https://questland-public-api.cfapps.io/booming-turtle.png")
            .build(),
        DisplayableBuild.builder()
            .build(WARDING_FANG)
            .name("Warding Fang")
            .weapons(RED_HOARDER_MAIN_HAND + ", Fiery Fury Ward")
            .mainHandAlternatives(RED_HOARDER_MAIN_HAND_BACKUP)
            .offHandAlternatives("Stunning White: None")
            .talent1("Bloodlust")
            .talent2("Transcendental Tornado")
            .talent3("Crest Guardian")
            .videoGuide("https://www.youtube.com/watch?v=H_3Zx1aslTQ")
            .image("https://questland-public-api.cfapps.io/warding-fang.png")
            .build(),
        DisplayableBuild.builder()
            .build(FIRE_BLASTER)
            .name("Fire Blaster")
            .weapons(RED_HOARDER_MAIN_HAND + ", " + YOUR_HEAL_MY_GAIN_OFF_HAND)
            .mainHandAlternatives(RED_HOARDER_MAIN_HAND_BACKUP)
            .offHandAlternatives(YOUR_HEAL_MY_GAIN_OFF_HAND_BACKUP)
            .talent1("Inner Fire")
            .talent2("Chilling Cold")
            .talent3("Sacred Rage")
            .videoGuide("https://www.youtube.com/watch?v=kFRl03id704")
            .image("https://questland-public-api.cfapps.io/fire-blaster.png")
            .build(),
        DisplayableBuild.builder()
            .build(ICY_CANNON)
            .name("Icy Cannon")
            .weapons(GRANNY_BROTH_MAIN_HAND + ", " + YOUR_HEAL_MY_GAIN_OFF_HAND)
            .mainHandAlternatives(GRANNY_BROTH_MAIN_HAND_BACKUP)
            .offHandAlternatives(YOUR_HEAL_MY_GAIN_OFF_HAND_BACKUP)
            .talent1("Inner Fire")
            .talent2("Chilling Cold")
            .talent3("Sacred Rage")
            .videoGuide("https://www.youtube.com/watch?v=_SvZmoYtBLk")
            .image("https://questland-public-api.cfapps.io/icy-cannon.png")
            .build(),
        DisplayableBuild.builder()
            .build(THE_FARMER)
            .name("The Farmer")
            .description(
                "This build is amazing for farming anti-heal shield defense opponents of equal or lower power while not suffering heavily from dodge which makes it ideal for adding trophies to the system from farming lower opponents.")
            .weapons(RED_HOARDER_MAIN_HAND + ", " + YOUR_HEAL_MY_GAIN_OFF_HAND)
            .mainHandAlternatives(RED_HOARDER_MAIN_HAND_BACKUP)
            .offHandAlternatives(YOUR_HEAL_MY_GAIN_OFF_HAND_BACKUP)
            .talent1("Assassin's Way")
            .talent2("Divine Force")
            .talent3("Sacred Rage")
            .videoGuide("https://youtu.be/94gERd2SmzI")
            .image("https://questland-public-api.cfapps.io/the-farmer.png")
            .build()
    );
  }
}
