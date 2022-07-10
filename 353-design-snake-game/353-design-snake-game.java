class SnakeGame {
    int width;
    int height;
    int[][] food;
    Deque<Integer> snake;
    Set<Integer> set;
    int index;
    int score;
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        snake = new ArrayDeque<>();
        set = new HashSet<>();
        index = 0;
        int score = 0;
        snake.offerFirst(0);
        set.add(0);
    }
    
    public int move(String direction) {
        if (score < 0) {
            return -1;
        }
        int row = snake.peekFirst() / width;
        int col = snake.peekFirst() % width;
        if (direction.equals("U")) {
            row--;
        } else if (direction.equals("D")) {
            row++;
        } else if (direction.equals("L")) {
            col--;
        } else if (direction.equals("R")) {
            col++;
        }
        int newHead = row * width + col;
        int tail = snake.pollLast();
        set.remove(tail);
        if (row < 0 || row == height || col < 0 || col == width || set.contains(newHead)) {
            return score = -1;
        }
        set.add(newHead);
        snake.offerFirst(newHead);
        if (index < food.length && row == food[index][0] && col == food[index][1]) {
            index++;
            snake.offerLast(tail);
            set.add(tail);
            score++;
        }
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */