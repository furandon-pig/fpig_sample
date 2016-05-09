(set-language-environment "Japanese")
(display-time)
(line-number-mode t)
(column-number-mode t)
(global-font-lock-mode t)

(set-default-coding-systems 'utf-8)

;(tool-bar-mode 0)
(menu-bar-mode 0)
(global-set-key "\C-h" 'delete-backward-char)
(global-set-key "\M-g" 'goto-line)

(electric-indent-mode -1)
