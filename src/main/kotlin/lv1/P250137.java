package lv1;

public class P250137 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // t초 동안 x만큼의 체력을 회복하고, t초 연속 붕대감기 성공시 y만큼 추가 체력 회복
        // 최대 체력 존재
        // 기술 쓰거나, 공격 받으면 기술 사용 초기화, 맞은 순간엔 기술 못쓰고 그 뒤에 다시 즉시사용함 -> 연속 성공 시간 0초로 초기화
        // 체력이 0되면 사망, -1 리턴
        // bandage - [기술 시전 시간, 초당 회복량, 추가회복량]
        // health - 최대 체력
        // attacks - [[공격시간, 피해량], []...]

        int currentHealth = health;
        int heal = 0;
        int idx = 0;

        for (int i = 1; i < attacks[attacks.length - 1][0]; i++) {
            if (attacks[idx][0] == i) {
                heal = 0;
                currentHealth -= attacks[idx][1];
                idx++;
                if (currentHealth <= 0) return -1;
            } else {
                currentHealth += bandage[1];
                heal++;

                if (heal == bandage[0]) {
                    currentHealth += bandage[2];
                    heal = 0;
                }
                if (currentHealth > health) currentHealth = health;
            }
        }
        return currentHealth;

    }
}
