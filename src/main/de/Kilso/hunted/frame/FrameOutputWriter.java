package main.de.Kilso.hunted.frame;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class FrameOutputWriter {
    private static boolean threadRunning = false;
    JLabel targetComponent;

    private FrameOutputWriter(JLabel target) {
        this.targetComponent = target;
    }

    public void write(String string) {
        this.write(string.toCharArray());
    }

    public void write(char[] string) {
        new Runnable() {
            public void start() {
                if (!threadRunning) {
                    threadRunning = true;
                    run();
                }
            }

            @Override
            public void run() {
                StringBuffer bufferedText = new StringBuffer();
                for (int i = 0; i < string.length; i++) {
                    bufferedText = bufferedText.append(string[i]);
                    targetComponent.setText(bufferedText.toString());

                    try {
                        sleep(100);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }

                threadRunning = false;
            }
        }.start();
    }
}
