package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		/*
		 * NW - code with defensive programming - the committed original code was in an
		 * infinite looping
		 */
		p.setValues(position.getRow() - 1, (position.getColumn() - 1));

		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && p.getRow() > 0 && p.getColumn() > 0) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && p.getRow() > 0) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		/*
		 * NE - code with defensive programming - the committed original code was in an
		 * infinite looping
		 */
		p.setValues(position.getRow() - 1, (position.getColumn() + 1));

		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && p.getRow() > 0) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// SE
		p.setValues(position.getRow() + 1, (position.getColumn() + 1));
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		/*
		 * SW - code with defensive programming - the committed original code was in an
		 * infinite looping
		 */
		p.setValues(position.getRow() + 1, (position.getColumn() - 1));
		
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && p.getColumn() > 0) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
//	 	above
			p.setValues((position.getRow() - 1), position.getColumn());
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && p.getRow() > 0) {
				mat[p.getRow()][p.getColumn()] = true;
				p.setRow(p.getRow() - 1);
			}
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			/* 	left - code with defensive programming
			 	- the committed original code was in an infinite looping
			 */
			if ((p.getColumn() - 1) > 0) {
				p.setValues(position.getRow(), (position.getColumn() - 1));
			} else {
				p.setValues(position.getRow(), 0);
			}
			
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && p.getColumn() > 0) {
				mat[p.getRow()][p.getColumn()] = true;
				p.setColumn(p.getColumn() - 1);
			}
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			// 	right
			p.setValues(position.getRow(), (position.getColumn() + 1));
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				p.setColumn(p.getColumn() + 1);
			}
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			// 	below
			p.setValues((position.getRow() + 1), position.getColumn());
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				p.setRow(p.getRow() + 1);
			}
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			return mat;
	}

}
