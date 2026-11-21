"""Grafica la carga exacta y las salidas CSV calculadas por Java."""
import csv
from pathlib import Path

import matplotlib.pyplot as plt
import numpy as np

BASE = Path(__file__).resolve().parent
series = (
    ("020", "0.20", 5.0, "#006c74", "o"),
    ("010", "0.10", 2.5, "#ac4d10", "s"),
    ("005", "0.05", 1.25, "#6948a1", "^"),
)
fig, (ax, err) = plt.subplots(2, 1, figsize=(10, 7.1), layout="constrained",
                               gridspec_kw={"height_ratios": [1.4, 1]})
fig.suptitle("Circuito RLC: solución exacta y aproximación RK4 en Java",
             fontsize=16, fontweight="bold", color="#152b46")
t = np.linspace(0, 5, 800)
w = np.sqrt(.96)
ax.plot(t, np.exp(-.2*t)*(np.cos(w*t)+.2/w*np.sin(w*t)), color="#152b46",
        linewidth=2.0, label="Carga exacta", zorder=2)
for tag, h, end, color, mark in series:
    with (BASE / f"resultados-h{tag}.csv").open(newline="") as file:
        rows = list(csv.DictReader(file))
    t = np.array([float(r["t"]) for r in rows])
    q = np.array([float(r["y1"]) for r in rows])
    e = np.array([float(r["error_abs"]) for r in rows])
    assert len(t) == 26 and np.isclose(t[-1], end)
    ax.plot(t, q, linestyle="none", marker=mark, markersize=4.0, color=color,
            markerfacecolor="none", label=f"RK4 h={h} s", zorder=3)
    nonzero = e > 0
    err.semilogy(t[nonzero], e[nonzero], color=color, linewidth=1.45, marker=mark,
                 markersize=3.1, markevery=2, label=f"h={h} s")
    i = np.flatnonzero(np.isclose(t, 1))[0]
    err.scatter([1], [e[i]], s=38, marker=mark, color=color, zorder=4, edgecolor="white", linewidth=.6)
ax.set(ylabel="Carga q (C)", xlim=(-0.05, 5.05), xlabel="Tiempo t (s)")
ax.axhline(0, color="#8995a0", linewidth=.8, zorder=1)
ax.legend(loc="upper right", ncol=2)
err.axvline(1, color="#5d6976", linestyle="--", linewidth=1, label="Comparación: t=1 s")
err.set(ylabel="Error absoluto de carga (C)", xlim=(-.03, 5.05), xlabel="Tiempo t (s)")
err.legend(loc="lower right", ncol=2)
for panel in (ax, err):
    panel.grid(alpha=.22)
    panel.spines[["top", "right"]].set_visible(False)
fig.savefig(BASE / "grafica-rk4-rlc.png", dpi=180, facecolor="white")
