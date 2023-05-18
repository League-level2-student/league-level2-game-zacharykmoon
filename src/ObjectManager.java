import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Peashooter peashooter;
	Random rand = new Random();
	ArrayList<zombie> zombies = new ArrayList<zombie>();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	int score = 0;
	Random ran = new Random();

	ObjectManager(Peashooter peashooter) {
		this.peashooter = peashooter;
	}
	int getScore() {
		return score;
	}
	void addZombie() {
		zombie.add(new zombie(ran.nextInt(ZombieShooter.WIDTH), 0, 50, 50));

	}
	void update() {
		peashooter.update();
		for (int i = 0; i < zombie.size(); i++) {
zombie brain = zombies.get(i);
			brain.update();
			if (brain.y >= ZombieShooter.HEIGHT) {
				brain.active = false;

			}

		}
	
	for (int i = 0; i < projectiles.size(); i++) {
		Projectile proSkillz = projectiles.get(i);
		proSkillz.update();
		if (proSkillz.y <= 0) {
			proSkillz.active = false;
		}

	}
	}
	
	void purgeObjects() {
		for (int i = 0; i < zombies.size(); i++) {
			zombie brain = zombies.get(i);

			if (brain.y >= ZombieShooter.HEIGHT) {
				brain.active = false;

			}
			if (brain.active == false) {
				zombies.remove(i);
			}
		}

		for (int i = 0; i < projectiles.size(); i++) {
			Projectile proSkillz = projectiles.get(i);
			if (proSkillz.y <= 0) {
				proSkillz.active = false;
			}
			if (proSkillz.active == false) {
				projectiles.remove(i);
			}

		}
		// Projectile
	}

	void addzombie() {
		zombie.add(new zombie(rand.nextInt(ZombieShooter.WIDTH), 0, 100, 100));
	}

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	

	void draw(Graphics g) {
		peashooter.draw(g);
		for (int i = 0; i < zombie.size(); i++) {
			zombies.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}
	void checkCollision() {
		for (zombie zombie : zombies) {
			

			if (zombie.collisionBox.intersects(zombie.collisionBox)) {
				zombie.active = false;
				System.out.println("ship has died =(");
				break;
					
			}
			for (Projectile proSkillz : projectiles) {
			

				if (proSkillz.collisionBox.intersects(zombie.collisionBox)) {
					zombie.active = (false);
					proSkillz.active=(false);
					score += 1;
				}

			}
		}

	
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		addzombie();
	}
}
