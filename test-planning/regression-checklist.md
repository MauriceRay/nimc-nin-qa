# Regression Checklist — vNIN Expiry Window

Tracks the 72-hour expiry guarantee after the fix for #2.

## Pre-release gate
- [ ] vNIN issued now verifies within 72h
- [ ] Same vNIN at T+72h01m returns 410 Gone
- [ ] Response includes server-side expiry timestamp
- [ ] Clock skew >5 min still handled against server time, not device time

## Notes
Expiry must always be evaluated server-side; client clock must never be trusted.
