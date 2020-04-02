package com.company;

import static com.company.Main.EXECUTION_RALENTIT;

public class TrainB implements Runnable {

  Track_AB track_ab;
  Track_ABC track_abc;
  Track_B[] track_b;

  int id;

  TrainB(int id, Track_AB track_ab, Track_ABC track_abc, Track_B[] listTrack_b) {
    this.id = id;
    this.track_ab = track_ab;
    this.track_abc = track_abc;
    this.track_b = listTrack_b;
  }

  public void run() {
    try {
      while (true) {

        // ici vous pouvez ordonnez les étapes qu'effectue le train, et ajouter des delais ou des réparation
        // pour ajouter un delai a une track appeler la méthode BDelai : ex : track_ab.BDelai(this.id);
        // pour ajouter une panne a une track appeler la méthode BPanne : ex : track_ab.BPanne(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_b[0].BEnter(this.id);
        track_b[0].BExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_ab.BDelai(this.id);
        track_ab.BEnter(this.id);
        track_ab.BExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_b[1].BEnter(this.id);
        track_b[1].BExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_b[2].BEnter(this.id);
        track_b[2].BExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_b[3].BEnter(this.id);
        track_b[3].BExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_b[4].BEnter(this.id);
        track_b[4].BExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_abc.BDelai(this.id);
        track_abc.BEnter(this.id);
        track_abc.BExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_b[5].BEnter(this.id);
        track_b[5].BExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }

        track_b[6].BEnter(this.id);
        track_b[6].BExit(this.id);

        if (EXECUTION_RALENTIT) {
          Thread.sleep(1000);
        }
      }
    } catch (InterruptedException e) {
    }
  }
}