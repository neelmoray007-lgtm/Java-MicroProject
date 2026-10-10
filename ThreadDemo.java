package util;

public class ThreadDemo {

    private int reportCount = 0;


    // Synchronized method
    public synchronized void generateReport(
            String studentName) {

        System.out.println(
                Thread.currentThread().getName()
                + " is generating report for "
                + studentName
        );

        reportCount++;

        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {

            System.out.println(
                    "Report thread interrupted."
            );
        }

        System.out.println(
                Thread.currentThread().getName()
                + " completed report."
        );
    }


    // Runnable implementation
    class ReportTask implements Runnable {

        private String studentName;

        public ReportTask(String studentName) {
            this.studentName = studentName;
        }

        @Override
        public void run() {

            generateReport(studentName);
        }
    }


    // Wait and notify demonstration
    private final Object lock =
            new Object();

    private boolean reportReady = false;


    public void waitForReport() {

        synchronized (lock) {

            try {

                while (!reportReady) {

                    System.out.println(
                            Thread.currentThread().getName()
                            + " is waiting..."
                    );

                    lock.wait();
                }

                System.out.println(
                        Thread.currentThread().getName()
                        + " received the report."
                );

            } catch (InterruptedException e) {

                System.out.println(
                        "Waiting thread interrupted."
                );
            }
        }
    }


    public void completeReport() {

        synchronized (lock) {

            System.out.println(
                    Thread.currentThread().getName()
                    + " completed report preparation."
            );

            reportReady = true;

            lock.notify();
        }
    }


    public void demonstrateThreads() {

        System.out.println(
                "\n================================="
        );

        System.out.println(
                "          THREAD DEMO"
        );

        System.out.println(
                "================================="
        );


        // Thread using Runnable

        Thread thread1 =
                new Thread(
                        new ReportTask("Rahul"),
                        "Report-Thread-1"
                );

        Thread thread2 =
                new Thread(
                        new ReportTask("Priya"),
                        "Report-Thread-2"
                );


        // Thread priority

        thread1.setPriority(
                Thread.MAX_PRIORITY
        );

        thread2.setPriority(
                Thread.MIN_PRIORITY
        );


        System.out.println(
                "Thread 1 priority: "
                + thread1.getPriority()
        );

        System.out.println(
                "Thread 2 priority: "
                + thread2.getPriority()
        );


        // Start threads

        thread1.start();
        thread2.start();


        try {

            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {

            System.out.println(
                    "Main thread interrupted."
            );
        }


        System.out.println(
                "Total reports generated: "
                + reportCount
        );


        // wait() and notify()

        System.out.println(
                "\n--- WAIT / NOTIFY DEMO ---"
        );


        Thread waitingThread =
                new Thread(
                        () -> waitForReport(),
                        "Waiting-Thread"
                );


        Thread completingThread =
                new Thread(
                        () -> {

                            try {

                                Thread.sleep(1500);

                            } catch (InterruptedException e) {

                                System.out.println(
                                        "Completing thread interrupted."
                                );
                            }

                            completeReport();
                        },
                        "Completing-Thread"
                );


        waitingThread.start();
        completingThread.start();


        try {

            waitingThread.join();
            completingThread.join();

        } catch (InterruptedException e) {

            System.out.println(
                    "Main thread interrupted."
            );
        }


        System.out.println(
                "\nThread demonstration completed."
        );
    }
}

