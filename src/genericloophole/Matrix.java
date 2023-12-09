package genericloophole;

class Matrix<N extends Number> {
    private N[][] matrix;

    Matrix(N[][] matrix) throws Exception {
        if (matrix.length != 0) {
            this.matrix = matrix;
        } else {
            throw new Exception("EMPTY MATRIX PASSED TO CONSTRUCTOR");
        }
    }

    public void add(N[][] other) throws Exception {
        if (other.length != matrix.length || other[0].length != matrix[0].length) {
            throw new Exception("Matrix dimensions are not compatible for addition.");
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Calculator.sum(matrix[i][j], other[i][j]);
            }
        }
    }

    public void sub(N[][] other) throws Exception {
        if (other.length != matrix.length || other[0].length != matrix[0].length) {
            throw new Exception("Matrix dimensions are not compatible for addition.");
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Calculator.subtraction(matrix[i][j], other[i][j]);
            }
        }
    }

    public void multiply(N[][] other) throws Exception {
        int rowsA = matrix.length;
        int colsA = matrix[0].length;
        int rowsB = other.length;
        int colsB = other[0].length;

        if (colsA != rowsB) {
            throw new Exception("Matrix dimensions are not compatible for multiplication.");
        }

        N[][] result = (N[][]) new Number[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                N sum = Calculator.sum(matrix[i][0], other[0][j]);
                for (int k = 1; k < colsA; k++) {
                    sum = Calculator.sum(sum, Calculator.multiply(matrix[i][k], other[k][j]));
                }
                result[i][j] = sum;
            }
        }

        // Update the matrix with the result
        this.matrix = result;
    }

    public N[][] getMatrix() {
        return matrix;
    }

    public void printMatrix() {
        for (final var row : matrix) {
            for (final var element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        try {
            // Example usage
            Integer[][] mat1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };

            Integer[][] mat2 = {
                {10, 11, 12},
                {13, 14, 15},
                {16, 17, 18}
            };

            Double[][] mat3 = {
                {1.1, 2.2, 3.3},
                {4.4, 5.5, 6.6},
                {7.7, 8.8, 9.9}
            };

            Double[][] mat4 = {
                {10.1, 11.1, 12.1},
                {13.2, 14.2, 15.2},
                {16.3, 17.3, 18.3}
            };


            Matrix<Integer> mat = new Matrix<>(mat1);

            mat.multiply(mat2); // change
            System.out.println("Matrix 1 * Matrix 2:");
            mat.printMatrix();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

