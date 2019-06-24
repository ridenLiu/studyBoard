package API.thread.ThreadBlog;

public class StudentAssistant {
    ThreadLocal<String> realName = new ThreadLocal<>();
    ThreadLocal<Double> totalScore = new ThreadLocal<>();

    String determineDegree() {
        double score = totalScore.get();
        if (score >= 90) {
            return "A";
        }
        if (score >= 80) {
            return "B";
        }
        if (score >= 70) {
            return "C";
        }
        if (score >= 60) {
            return "D";
        }
        return "E";
    }

    double determineOptionalcourseScore() {
        double score = totalScore.get();
        if (score >= 90) {
            return 10;
        }
        if (score >= 80) {
            return 20;
        }
        if (score >= 70) {
            return 30;
        }
        if (score >= 60) {
            return 40;
        }
        return 60;
    }
}
