" vim:set ts=8 sts=2 sw=2 tw=0: (���ιԤ˴ؤ��Ƥ�:help modeline�򻲾�)
"
" An example for a Japanese version vimrc file.
" ���ܸ��ǤΥǥե��������ե�����(vimrc) - Vim7�ѻ��
"
" Last Change: 18-Nov-2010.
" Maintainer:  MURAOKA Taro <koron@tka.att.ne.jp>
"
" ����:
" ���Υե�����ˤ�Vim�ε�ư����ɬ�����ꤵ��롢�Խ����ε�ư�˴ؤ������꤬��
" ����Ƥ��ޤ���GUI�˴ؤ��������gvimrc�˽񤫤���Ƥ��ޤ���
"
" �Ŀ��������_vimrc�Ȥ����ե����������������ǹԤʤ��ޤ���_vimrc�Ϥ��Υե�
" ����θ���ɹ��ޤ�뤿�ᡢ�����˽񤫤줿���Ƥ��񤭤������ꤹ�뤳�Ȥ�����
" �ޤ���_vimrc��$HOME�ޤ���$VIM���֤��Ƥ���ɬ�פ�����ޤ���$HOME��$VIM����
" ͥ�褵�졢$HOME�ǤߤĤ��ä����$VIM���ɹ��ޤ�ޤ���
"
" �����Ը�����������ե������ľ�ܽ񤭴������˺Ѥޤ��뤳�Ȥ���Ū�Ȥ��ơ�����
" �ȥ������������̥ե�����ǹԤʤ���褦����θ���Ƥ���ޤ���Vim��ư����
" �����ȥ����������ե�����($VIM/vimrc_local.vim)��¸�ߤ���ʤ�С�������
" �ե�����μ�����ʬ���ɤ߹��ޤ�����˼�ưŪ���ɤ߹��ߤޤ���
"
" �ɤ߹��߸塢�ѿ�g:vimrc_local_finish����0���ͤ����ꤵ��Ƥ������ˤ�����
" ��ե�����˽񤫤줿���Ƥϰ��ڼ¹Ԥ���ޤ��󡣥ǥե����ư������ƺ����ؤ�
" �����������Ѥ��Ʋ�������
"
" ����:
"   :help vimrc
"   :echo $HOME
"   :echo $VIM
"   :version

"---------------------------------------------------------------------------
" �����ȥ����������($VIM/vimrc_local.vim)��������ɤ߹��ࡣ�ɤ߹�������
" �ѿ�g:vimrc_local_finish����0���ͤ����ꤵ��Ƥ������ˤϡ�����ʾ������
" �ե�������ɹ�����ߤ��롣
if 1 && filereadable($VIM . '/vimrc_local.vim')
  unlet! g:vimrc_local_finish
  source $VIM/vimrc_local.vim
  if exists('g:vimrc_local_finish') && g:vimrc_local_finish != 0
    finish
  endif
endif

"---------------------------------------------------------------------------
" �桼��ͥ������($HOME/.vimrc_first.vim)��������ɤ߹��ࡣ�ɤ߹��������ѿ�
" g:vimrc_first_finish����0���ͤ����ꤵ��Ƥ������ˤϡ�����ʾ������ե�
" ������ɹ�����ߤ��롣
if 0 && exists('$HOME') && filereadable($HOME . '/.vimrc_first.vim')
  unlet! g:vimrc_first_finish
  source $HOME/.vimrc_first.vim
  if exists('g:vimrc_first_finish') && g:vimrc_first_finish != 0
    finish
  endif
endif

"---------------------------------------------------------------------------
" ���ܸ��б��Τ��������:
"
" �ե�������ɹ�����˥ȥ饤����ʸ�����󥳡��ɤν������ꤹ�롣���������ɼ�
" ưȽ�̵�ǽ�����Ѥ�����ˤ�����iconv.dll��ɬ�ס�iconv.dll�ˤĤ��Ƥ�
" README_w32j.txt�򻲾ȡ��桼�ƥ���ƥ�������ץȤ��ɤ߹��ळ�Ȥ����ꤵ��롣
" ��å����������ܸ�ˤ��� (Windows�Ǥϼ�ưŪ��Ƚ�ǡ����ꤵ��Ƥ���)
if filereadable('$VIMRUNTIME/encode_japan.vim')
  source $VIMRUNTIME/encode_japan.vim
endif
if !(has('win32') || has('mac')) && has('multi_lang')
  if !exists('$LANG') || $LANG.'X' ==# 'X'
    if !exists('$LC_CTYPE') || $LC_CTYPE.'X' ==# 'X'
      language ctype ja_JP.UTF-8
    endif
    if !exists('$LC_MESSAGES') || $LC_MESSAGES.'X' ==# 'X'
      language messages ja_JP.UTF-8
    endif
  endif
endif
" MacOS X��˥塼�����ܸ첽 (��˥塼ɽ�����˹Ԥʤ�ɬ�פ�����)
if has('mac')
  set langmenu=japanese
endif
" ���ܸ������Ѥ�keymap�������� (�����ȥ�����)
if has('keymap')
  " ���޻���̾��keymap
  "silent! set keymap=japanese
  "set iminsert=0 imsearch=0
endif
" ��GUI���ܸ쥳�󥽡����ȤäƤ����������
if !has('gui_running') && &encoding != 'cp932' && &term == 'win32'
  set termencoding=cp932
endif

"---------------------------------------------------------------------------
" ��˥塼�ե����뤬¸�ߤ��ʤ�����ͽ��'guioptions'��Ĵ�����Ƥ���
if 1 && !filereadable($VIMRUNTIME . '/menu.vim') && has('gui_running')
  set guioptions+=M
endif

"---------------------------------------------------------------------------
" Bram����󶡤���������򥤥󥯥롼�� (�̥ե�����:vimrc_example.vim)������
" ������g:no_vimrc_example����0���ͤ����ꤷ�Ƥ����Х��󥯥롼�ɤϤ��ʤ���
if 1 && (!exists('g:no_vimrc_example') || g:no_vimrc_example == 0)
  if &guioptions !~# "M"
    " vimrc_example.vim���ɤ߹������guioptions��M�ե饰��Ĥ��ơ�syntax on
    " ��filetype plugin on������������menu.vim���ɤ߹��ߤ��򤱤롣�������ʤ�
    " ��enc���б������˥塼�ե����뤬�ɤ߹��ޤ�Ƥ��ޤ�������θ���ɤ߹�
    " �ޤ��.vimrc��enc�����ꤵ�줿���ˤ������꤬ȿ�Ǥ��줺��˥塼��ʸ��
    " �����Ƥ��ޤ���
    set guioptions+=M
    source $VIMRUNTIME/vimrc_example.vim
    set guioptions-=M
  else
    source $VIMRUNTIME/vimrc_example.vim
  endif
endif

"---------------------------------------------------------------------------
" �����ε�ư�˴ؤ�������:
"
" ����������ʸ����ʸ����̵�� (noignorecase:̵�뤷�ʤ�)
set ignorecase
" ��ʸ����ʸ����ξ�����ޤޤ�Ƥ��������ʸ����ʸ�������
set smartcase

"---------------------------------------------------------------------------
" �Խ��˴ؤ�������:
"
" ���֤β��̾�Ǥ���
set tabstop=8
" ���֤򥹥ڡ�����Ÿ�����ʤ� (expandtab:Ÿ������)
set noexpandtab
" ��ưŪ�˥���ǥ�Ȥ��� (noautoindent:����ǥ�Ȥ��ʤ�)
set autoindent
" �Хå����ڡ����ǥ���ǥ�Ȥ���Ԥ����Ǥ���褦�ˤ���
set backspace=2
" �������˥ե�����κǸ�ޤǹԤä���ǽ����� (nowrapscan:���ʤ�)
set wrapscan
" ������ϻ����б������̤�ɽ�� (noshowmatch:ɽ�����ʤ�)
set showmatch
" ���ޥ�ɥ饤���䴰����Ȥ��˶������줿��Τ�Ȥ�(���� :help wildmenu)
set wildmenu
" �ƥ�����������μ�ư�ޤ��֤������ܸ���б�������
set formatoptions+=mM
" ���ܸ�����������ץ�(by. �������Τ���)�Ѥ�����
let format_allow_over_tw = 1	" �֤鲼���ǽ��

"---------------------------------------------------------------------------
" GUI��ͭ�ǤϤʤ�����ɽ��������:
"
" ���ֹ����ɽ�� (number:ɽ��)
set nonumber
" �롼�顼��ɽ�� (noruler:��ɽ��)
set ruler
" ���֤���Ԥ�ɽ�� (list:ɽ��)
set nolist
" �ɤ�ʸ���ǥ��֤���Ԥ�ɽ�����뤫������
"set listchars=tab:>-,extends:<,trail:-,eol:<
" Ĺ���Ԥ��ޤ��֤���ɽ�� (nowrap:�ޤ��֤��ʤ�)
set wrap
" ��˥��ơ������Ԥ�ɽ�� (�ܺ٤�:he laststatus)
set laststatus=1
" ���ޥ�ɥ饤��ι⤵ (Windows��gvim���ѻ���gvimrc���Խ����뤳��)
set cmdheight=2
" ���ޥ�ɤ򥹥ơ������Ԥ�ɽ��
set showcmd
" �����ȥ��ɽ��
set title
" ���̤���Ϥ���ˤ��� (���Ԥ���Ƭ�� " ���������ͭ���ˤʤ�)
"colorscheme evening " (Windows��gvim���ѻ���gvimrc���Խ����뤳��)

"---------------------------------------------------------------------------
" �ե��������˴ؤ�������:
"
" �Хå����åץե������������ʤ� (���Ԥ���Ƭ�� " ���������ͭ���ˤʤ�)
"set nobackup


"---------------------------------------------------------------------------
" �ե�����̾����ʸ����ʸ���ζ��̤��ʤ������ƥ��Ѥ�����:
"   (��: DOS/Windows/MacOS)
"
if filereadable($VIM . '/vimrc') && filereadable($VIM . '/ViMrC')
  " tags�ե�����ν�ʣ�ɻ�
  set tags=./tags,tags
endif

"---------------------------------------------------------------------------
" ���󥽡���ǤΥ��顼ɽ���Τ��������(����Ū��UNIX����)
if has('unix') && !has('gui_running')
  let uname = system('uname')
  if uname =~? "linux"
    set term=builtin_linux
  elseif uname =~? "freebsd"
    set term=builtin_cons25
  elseif uname =~? "Darwin"
    set term=screen
    "set term=beos-ansi
  else
    "set term=builtin_xterm
    set term=screen
  endif
  unlet uname
endif

"---------------------------------------------------------------------------
" ���󥽡����ǤǴĶ��ѿ�$DISPLAY�����ꤵ��Ƥ���ȵ�ư���٤��ʤ����б�
if !has('gui_running') && has('xterm_clipboard')
  set clipboard=exclude:cons\\\|linux\\\|cygwin\\\|rxvt\\\|screen
endif

"---------------------------------------------------------------------------
" �ץ�åȥۡ����¸�����̤�����

" Win�Ǥ�PATH��$VIM���ޤޤ�Ƥ��ʤ��Ȥ���exe�򸫤Ĥ��Ф��ʤ��Τǽ���
if has('win32') && $PATH !~? '\(^\|;\)' . escape($VIM, '\\') . '\(;\|$\)'
  let $PATH = $VIM . ';' . $PATH
endif

if has('mac')
  " Mac�Ǥϥǥե���Ȥ�'iskeyword'��cp932���б�������Ƥ��ʤ��Τǽ���
  set iskeyword=@,48-57,_,128-167,224-235
endif

" Copyright (C) 2007 KaoriYa/MURAOKA Taro


"---------------------------------------------------------------------------
" �ʲ��ϼ�ʬ�Ѥ�����

if has('win32')
  set backupdir=C:/tmp/vim
  set directory=C:/tmp/vim
else
  set backupdir=~/tmp/vim
  set directory=~/tmp/vim
  set runtimepath=$HOME/.vim,/usr/local/share/vim/vim74
endif

set backup
set swapfile

" �������˥ϥ��饤��ɽ����Esc��2��Ϣ�Ǥ���ȥϥ��饤��ɽ������
set hlsearch
nmap <Esc><Esc> :nohlsearch<CR><Esc>

" window splitting like the emacs.
nmap <C-w>0 :close<CR>
nmap <C-w>1 :on<CR>
nmap <C-w>2 :sp<CR>
nmap <C-w>3 :vs<CR>

syntax on
set number

filetype on
filetype indent on
filetype plugin on

"" gnu global key mapping.
map <ESC><C-g> :Gtags
map <C-i> :Gtags -f %<CR>
map <C-j> :GtagsCursor<CR>
"map <LEFT> <ESC>:bp<CR>
"map <RIGHT> <ESC>:bn<CR>
"map <UP> <ESC>:ls<CR>
"" �������Window���Ĥ���
"nnoremap <C-q> <C-w><C-w><C-w>q
"" Grep ����
"nnoremap <C-g> :Gtags -g
"" ���Υե�����δؿ�����
"nnoremap <C-l> :Gtags -f %<CR>
"" ��������ʲ����������õ��
"nnoremap <C-j> :Gtags <C-r><C-w><CR>
"" ��������ʲ��λ��Ѳս��õ��
"nnoremap <C-k> :Gtags -r <C-r><C-w><CR>
"" ���θ������
nnoremap <C-n> :cn<CR>
"" ���θ������
nnoremap <C-p> :cp<CR>

" window split setting.
map <C-w>0 :close<CR>
map <C-w>1 :on<CR>
map <C-w>2 :sp<CR>
map <C-w>3 :vs<CR>

" tab window setting.
map <ESC>t :tabe %<CR>
map <C-l> :tabn<CR>
map <C-h> :tabN<CR>

" build command.
map <ESC>b :make<CR>
map <ESC>u :make run<CR>

" binary operation.
map <ESC><C-d><C-d> :%!xxd<CR>
map <ESC><C-r><C-r> :%!xxd -r<CR>

hi TabLineFill ctermbg=white ctermfg=gray
hi TabLineSel  ctermbg=black ctermfg=red
hi TabLine     ctermbg=gray  ctermfg=black

set laststatus=2

"syntax off
