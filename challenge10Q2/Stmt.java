package com.craftinginterpreters.lox;

public abstract class Stmt {
  public interface Visitor<R> {
    R visitFunctionStmt(Function stmt);
    // ... other visitor methods ...
  }

  public static class Function extends Stmt {
    public final Token name;
    public final Expr.Function function; // <-- changed: store Expr.Function

    public Function(Token name, Expr.Function function) {
      this.name = name;
      this.function = function;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
      return visitor.visitFunctionStmt(this);
    }
  }

  // ... other Stmt subclasses ...

  public abstract <R> R accept(Visitor<R> visitor);
}