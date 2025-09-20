package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.pathfinding.PathfindingConstants.Branch;
import frc.robot.subsystems.elevator.ElevatorConstants;
import frc.robot.utilities.FieldConstants.ReefFace;
import org.littletonrobotics.junction.networktables.LoggedDashboardChooser;

import static frc.robot.subsystems.elevator.ElevatorConstants.ElevatorHeight.L2;
import static frc.robot.subsystems.elevator.ElevatorConstants.ElevatorHeight.L4;
import static frc.robot.utilities.FieldConstants.ReefFace.FACE_0;

public class Questionnaire {
    private final LoggedDashboardChooser<String> PRESET_QUESTION;
    private final Cycle
            CYCLE_1,
            CYCLE_2,
            CYCLE_3;

    public Questionnaire() {
        PRESET_QUESTION = createPresetQuestion();

        CYCLE_1 = initializeCycleFromKey("1");
        CYCLE_2 = initializeCycleFromKey("2");
        CYCLE_3 = initializeCycleFromKey("3");
    }

    private Cycle initializeCycleFromKey(String key) {
        return new Cycle(createReefFaceQuestion(key),
                createBranchQuestion(key),
                createScoringQuestion(key),
                createFeederQuestion(key));
    }

    private LoggedDashboardChooser<String> createPresetQuestion() {
        final LoggedDashboardChooser<String> question = new LoggedDashboardChooser<>("Which Auto?");

        return question;
    }

    private LoggedDashboardChooser<ReefFace> createReefFaceQuestion(String cycleNumber) {
        final LoggedDashboardChooser<ReefFace> question = new LoggedDashboardChooser<>(cycleNumber + "Which Reef Face?");

        question.addDefaultOption("#" + cycleNumber+ " Face 0", FACE_0);

        for (ReefFace face : ReefFace.values()) {
            if (face == FACE_0) continue;

            question.addOption("#" + cycleNumber+ " Face " + face.ordinal(), face);
        }

        return question;
    }

    private LoggedDashboardChooser<Branch> createBranchQuestion(String cycleNumber) {
        final LoggedDashboardChooser<Branch> question = new LoggedDashboardChooser<>(cycleNumber + "Which Branch?");

        question.addDefaultOption("#" + cycleNumber+ " Left", Branch.LEFT_BRANCH);
        question.addOption("#" + cycleNumber+ " Right", Branch.RIGHT_BRANCH);

        return question;
    }

    private LoggedDashboardChooser<ElevatorConstants.ElevatorHeight> createScoringQuestion(String cycleNumber) {
        final LoggedDashboardChooser<ElevatorConstants.ElevatorHeight> question = new LoggedDashboardChooser<>(cycleNumber + "Which Scoring Level?");

        question.addDefaultOption("#" + cycleNumber+ " L4", L4);
        question.addOption("#" + cycleNumber+ " L2", L2);

        return question;
    }

    private LoggedDashboardChooser<Command> createFeederQuestion(String cycleNumber) {
        final LoggedDashboardChooser<Command> question = new LoggedDashboardChooser<>(cycleNumber + "Which Feeder?");

        return question;
    }

    private Command createCycleSequence(Cycle cycle) {
        return new Command() {};
    }

    public Command getCommand() {
        return Commands.sequence(
                createCycleSequence(CYCLE_1),
                createCycleSequence(CYCLE_2),
                createCycleSequence(CYCLE_3)
        );
    }

    public String getSelected() {
        return PRESET_QUESTION.getSendableChooser().getSelected() != "None" ? PRESET_QUESTION.get() : "Custom";
    }

    private record Cycle(
            LoggedDashboardChooser<ReefFace> reefFaceQuestion,
            LoggedDashboardChooser<Branch> branchQuestion,
            LoggedDashboardChooser<ElevatorConstants.ElevatorHeight> scoringHeightQuestion,
            LoggedDashboardChooser<Command> feederQuestion) {
    }
}