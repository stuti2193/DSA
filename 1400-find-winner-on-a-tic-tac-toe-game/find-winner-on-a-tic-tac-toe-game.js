var tictactoe = function(moves) {
    let board = Array.from({ length: 3 }, () => Array(3).fill(" "));

    // Fill the board
    for (let i = 0; i < moves.length; i++) {
        let [row, col] = moves[i];

        // A -> X, B -> O
        board[row][col] = (i % 2 === 0) ? "X" : "O";
    }

    // Function to check winner
    function checkWinner(player) {

        // Rows
        for (let i = 0; i < 3; i++) {
            if (
                board[i][0] === player &&
                board[i][1] === player &&
                board[i][2] === player
            ) {
                return true;
            }
        }

        // Columns
        for (let i = 0; i < 3; i++) {
            if (
                board[0][i] === player &&
                board[1][i] === player &&
                board[2][i] === player
            ) {
                return true;
            }
        }

        // Main diagonal
        if (
            board[0][0] === player &&
            board[1][1] === player &&
            board[2][2] === player
        ) {
            return true;
        }

        // Other diagonal
        if (
            board[0][2] === player &&
            board[1][1] === player &&
            board[2][0] === player
        ) {
            return true;
        }

        return false;
    }

    // Check winner
    if (checkWinner("X")) {
        return "A";
    }

    if (checkWinner("O")) {
        return "B";
    }

    // All 9 cells filled
    if (moves.length === 9) {
        return "Draw";
    }

    // Game is not over
    return "Pending";
};