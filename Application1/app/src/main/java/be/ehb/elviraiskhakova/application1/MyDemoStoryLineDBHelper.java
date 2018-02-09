package be.ehb.elviraiskhakova.application1;

import cz.mendelu.busItWeek.library.StoryLineDatabaseHelper;
import cz.mendelu.busItWeek.library.builder.StoryLineBuilder;

/**
 * Created by elvira.iskhakova on 06-Feb-18.
 */

public class MyDemoStoryLineDBHelper extends StoryLineDatabaseHelper {

    public MyDemoStoryLineDBHelper() {
        super(75);

    }

    @Override
    protected void onCreate(StoryLineBuilder builder) {
        builder.addGPSTask("1")
                .radius(10)
                .location(49.210967, 16.616488)
                .victoryPoints(50)
                .simplePuzzle()
                .question("Which animal likes to be here?")
                .answer("Rabbit")
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("2")
                .location(49.210226, 16.614987)
                .victoryPoints(50)
                .radius(10)
                .imageSelectPuzzle()
                .addImage(R.drawable.plaats1_1, false)
                .addImage(R.drawable.plaats1_2, false)
                .addImage(R.drawable.plaats1_fout, true)
                .addImage(R.drawable.plaats1_3, false)
                .question("Which picture isn't taken here?")
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("3")
                .radius(10)
                .location(49.210333, 16.614792)
                .victoryPoints(100)
                .simplePuzzle()
                .question("How much does a water, a apple juice and a Fanta costs in the vending machine here? (in crones)")
                .answer("61")
                .hint("Hint here") //no images possible, just strings , for image use .hint("imagename")
                .puzzleDone()
                .taskDone();
        
        builder.addGPSTask("4")
                .radius(10)
                .location(49.210490, 16.615230)
                .victoryPoints(50)
                .simplePuzzle()
                .question("Who will be playing on Saturday at 15u15 on the Erasmus days?")
                .answer("Ceepus")
                .answer("ceepus")
                .hint("Hint here") //no images possible, just strings , for image use .hint("imagename")
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("5")
                .location(49.210874, 16.614810)
                .victoryPoints(100)
                .radius(10)
                .imageSelectPuzzle()
                .addImage(R.drawable.plaats2_1, false)
                .addImage(R.drawable.plaats2_fout, true)
                .addImage(R.drawable.plaats2_2, false)
                .addImage(R.drawable.plaats2_3, false)
                .question("Which picture isn't taken here?")
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("6")
                .radius(10)
                .location( 49.210696, 16.616744)
                .victoryPoints(50)
                .simplePuzzle()
                .question("How many years did J.C. Mendel live?")
                .answer("62")
                .hint("Hint here") //no images possible, just strings , for image use .hint("imagename")
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("7")
                .radius(10)
                .location( 49.211632, 16.617428)
                .victoryPoints(100)
                .simplePuzzle()
                .question("I have a twin brother. What is my name?")
                .answer("Posyp")
                .answer("posyp")
                .hint("Hint here") //no images possible, just strings , for image use .hint("imagename")
                .puzzleTime(300000)
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("8")
                .radius(10)
                .location( 49.212015, 16.616999)
                .victoryPoints(50)
                .simplePuzzle()
                .question("5 years ago Ann was 5 times as old as her nephew.\n" +
                        "\n" +
                        "In 5 years Ann's age will be 8 less than 3 times her nephew's age at that time. \n" +
                        "What is her nephew's age?\n")
                .answer("11")
                .hint("Hint here") //no images possible, just strings , for image use .hint("imagename")
                .puzzleDone()
                .taskDone();

        /*
        builder.addCodeTask("9")
                .qr("http://techdrev.ldf.mendelu.cz/cz/vyma/pedo/loma/pdk-p/p076")
                //.location(49.212015, 16.616999)
                .location( 49.212015, 16.616999)
                .victoryPoints(50)
                .taskDone();

/*        builder.addBeaconTask("10")
                .location(49.210542, 16.614825)
                .beacon(52307, 40318)
                .taskDone();
                */
    }
}
