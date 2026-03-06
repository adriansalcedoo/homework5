package com.craftinginterpreters.lox;

import java.util.List;

public abstract class Expr {
  public interface Visitor<R> {
    R visitFunctionExpr(Function expr);
    // ... other visitor methods ...
  }

  public static class Function extends Expr {
    public final List<Token> parameters;
    public final List<Stmt> body;

    public Function(List<Token> parameters, List<Stmt> body) {
      this.parameters = parameters;
      this.body = body;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
      return visitor.visitFunctionExpr(this);
    }
  }

  // ... existing Expr subclasses, e.g. Binary, Literal, Grouping, etc. ...

  public abstract <R> R accept(Visitor<R> visitor);
}