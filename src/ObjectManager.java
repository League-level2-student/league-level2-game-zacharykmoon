import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Peashooter peashooter;
	Random rand = new Random();
	ArrayList<zombie> aliens = new ArrayList<zombie>();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	int score = 0;

	ObjectManager(Peashooter peashooter) {
		this.peashooter = peashooter;
	}
	int getScore() {
		return score;
	}
	
	void purgeObjects() {
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).active == false) {
				projectiles.remove(projectiles.get(i));
			}
		}

		for (int i = 0; i < aliens.size(); i++) {
			if (zombie.get(i).active == false) {
				zombie.remove(zombie.get(i));
			}
		}
	}

	void addzombie() {
		zombie.add(new zombie(rand.nextInt(ZombieShooter.WIDTH), 0, 100, 100));
	}

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	void update() {
		
		peashooter.update();
		
		if (peashooter.active == true) {

			for (int i = 0; i < aliens.size(); i++) {
				aliens.get(i).update();
				if (aliens.get(i).y > ZombieShooter.HEIGHT) {
					aliens.get(i).active = false;
				}
			}
			for (int i = 0; i < projectiles.size(); i++) {
				projectiles.get(i).update();
				if (projectiles.get(i).y < 0) {
					projectiles.get(i).active = false;
				}
			}
			checkCollision();
			purgeObjects();
		}
	}

	void draw(Graphics g) {
		peashooter.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile.get(i).draw(g);
		}
	}

	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if (peashooter.collisionBox.intersects(aliens.get(i).collisionBox) == true) {
				peashooter.active = false;
				zombie.get(i).active = false;
			}
			
		}
		for (int i = 0; i < aliens.size(); i++) {
			for(int i2=0; i2 < projectiles.size(); i2++) {
			if (projectiles.get(i2).collisionBox.intersects(aliens.get(i).collisionBox) == true) {
				projectiles.get(i2).active = false;
				aliens.get(i).active = false;
				score+=1;
				}
		}
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		addzombie();
	}
}
