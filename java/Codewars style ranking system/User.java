public class User {
  public int rank = -8;
  public int progress = 0;
  public static int lastID = 1;
  public int ID = 1;
  
  public User() {
    this.ID = lastID++;
  }
  
  public void incProgress(int rank) {
    checkRank(rank);
    if (rank > 0 && this.rank < 0) rank--;
    
    if (rank < this.rank) {
      if (this.rank <= rank - 2) return;
      
      this.progress += 1;
      return;
    }
    if (this.rank == rank) {
      this.progress += this.rank == 8 ? 0 : 3;
      return;
    }
    int d = rank - this.rank;
    this.progress += 10 * d * d;
    
    checkProgress();
  }
  
  public void checkProgress() {
    
    while (progress >= 100) {
      progress -= 100;
      this.rank += 1;
      if (this.rank == 0) rank = 1;
      
      if (rank == 8) {
        progress = 0;
      }
    }
    
    if (rank > 8 || rank < -8 || rank == 0) throw new RuntimeException("Rank: " + rank + " is out of bounds.");
  }
  
  public void checkRank(int rank) {
    if (rank > 8 || rank < -8 || rank == 0) throw new IllegalArgumentException("Rank: " + rank + "is out of bounds.");
  }
}
