package com.company;

import static com.company.Main.EXECUTION_RALENTIT;

public class TrainA implements Runnable {


  Track_AB track_ab;
  Track_ABC track_abc;
  Track_A[] track_a;
  int id;

  TrainA(int id, Track_AB track_ab, Track_ABC track_abc, Track_A[] listTrack_a) {
    this.id = id;
    this.track_ab = track_ab;
    this.track_abc = track_abc;
    this.track_a = listTrack_a;
  }

  public void run() {
    try {
      while (true) {

        // ici vous pouvez ordonnez les étapes qu'effectue le train, et ajouter des delais ou des réparation
        // pour ajouter un delai a une track appeler la méthode ADelai : ex : track_ab.ADelai(this.id);
        // pour ajouter une panne a une track appeler la méthode APanne : ex : track_ab.APanne(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_a[0].APanne(this.id);
        track_a[0].AEnter(this.id);
        track_a[0].AExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_ab.ADelai(this.id);
        track_ab.AEnter(this.id);
        track_ab.AExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_a[1].AEnter(this.id);
        track_a[1].AExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_a[2].AEnter(this.id);
        track_a[2].AExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_abc.AEnter(this.id);
        track_abc.AExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_a[3].AEnter(this.id);
        track_a[3].AExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_a[4].AEnter(this.id);
        track_a[4].AExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

      }
    } catch (InterruptedException e) {
    }
  }
}