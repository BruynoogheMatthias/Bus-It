package be.ehb.elviraiskhakova.application1;

import cz.mendelu.busItWeek.library.StoryLineDatabaseHelper;
import cz.mendelu.busItWeek.library.builder.StoryLineBuilder;

/**
 * Created by elvira.iskhakova on 06-Feb-18.
 */

public class MyDemoStoryLineDBHelper extends StoryLineDatabaseHelper {

    public MyDemoStoryLineDBHelper() {
        super(34);
    }

    @Override
    protected void onCreate(StoryLineBuilder builder) {
        builder.addGPSTask("1")
                .radius(1000)
                .location(49.209605, 16.614272)
                .victoryPoints(5)
                .simplePuzzle()
                .question("Why did the chicken cross the road?")
                .answer("To get to the other side")
                .hint("Hint here") //no images possible, just strings , for image use .hint("imagename")
                .puzzleTime(30000)
                .puzzleDone()
                .taskDone();

        builder.addBeaconTask("2").location(49.210542, 16.614825)
                .beacon(5635, 2481)
                .choicePuzzle()
                .question("What is the best city in the world?")
                .addChoice("Brno", true)
                .addChoice("Prague", false)
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("3")
                .location(0, 0)
                .radius(50000)
                .imageSelectPuzzle()
                .addImage(R.drawable.image_1, false)
                .addImage(R.drawable.image_2, false)
                .addImage(R.drawable.image_3, true)
                .addImage(R.drawable.image_4, false)
                .question("Select chamomiles")
                .puzzleDone()
                .taskDone();

        builder.addCodeTask("4")
                .qr("Leuven")
                .location(49.216542, 16.314825)
                .simplePuzzle()
                .question("Who am I?")
                .answer("1")
                .puzzleDone()
                .taskDone();
    }
}
