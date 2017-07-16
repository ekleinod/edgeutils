# install script for simple jar project.

## Legal stuff
#
# Copyright 2010-2017 Ekkart Kleinod <ekleinod@edgesoft.de>
#
# This file is part of edgeUtils.
#
# edgeUtils is free software: you can redistribute it and/or modify
# it under the terms of the GNU Lesser General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# edgeUtils is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Lesser General Public License for more details.
#
# You should have received a copy of the GNU Lesser General Public License
# along with edgeUtils.  If not, see <http://www.gnu.org/licenses/>.
#
# @author Ekkart Kleinod
# @version 0.10.0
# @since 0.10.0

# use encoding: ISO-8859-15

Name ${PROJECT_NAME}

!define REGKEY "Software\${PROJECT_NAME}"
!define INSTALLNAME "${DIR_FILES}\${FILENAME}-${FILE_VERSION}.exe"

RequestExecutionLevel user

# MUI Symbol Definitions
!define MUI_ICON "${DIR_RESOURCES}images\installer_icon.ico"
!define MUI_FINISHPAGE_NOAUTOCLOSE
!define MUI_STARTMENUPAGE_REGISTRY_ROOT "HKLM" # store in registry under HKEY_LOCAL_MACHINE
!define MUI_STARTMENUPAGE_REGISTRY_KEY ${REGKEY}
!define MUI_STARTMENUPAGE_REGISTRY_VALUENAME ${FILENAME}
!define MUI_STARTMENUPAGE_DEFAULTFOLDER ${DIRNAME}

# Included files
!include Sections.nsh
!include MUI2.nsh

# Reserved Files
ReserveFile "${NSISDIR}\Plugins\AdvSplash.dll"

# Variables

# show warning when abort
!define MUI_ABORTWARNING
!define MUI_ABORTWARNING_TEXT "${LONGNAME} wurde nicht installiert.$\r$\n$\r$\n\
Sind Sie sicher, dass Sie die Installation abbrechen wollen?"

# Images
!define MUI_HEADERIMAGE
!define MUI_HEADERIMAGE_BITMAP "${DIR_RESOURCES}images\installer_header.bmp"
!define MUI_WELCOMEFINISHPAGE_BITMAP "${DIR_RESOURCES}images\installer_welcomefinish.bmp"

# Welcome
!define MUI_WELCOMEPAGE_TITLE "Installation $\"${LONGNAME}$\" ${LONG_VERSION}"
!define MUI_WELCOMEPAGE_TEXT "Willkommen bei der Installation von $\"${LONGNAME}$\".$\r$\n$\r$\n\
Dieser Installer führt Sie durch die Installation. \
Sie können die Installation jederzeit abbrechen, indem Sie unten rechts auf $\"Abbrechen$\" klicken."

!define MUI_FINISHPAGE_TITLE "Installation $\"${LONGNAME}$\" ${LONG_VERSION}"
!define MUI_FINISHPAGE_TEXT "Die Installation wurde erfolgreich abgeschlossen.$\r$\n$\r$\n\
Sie können das Installationsprogramm beenden und danach $\"${LONGNAME}$\" starten."

# Installer pages
!insertmacro MUI_PAGE_WELCOME
!insertmacro MUI_PAGE_COMPONENTS
!define MUI_PAGE_CUSTOMFUNCTION_LEAVE CopyExisting
!insertmacro MUI_PAGE_DIRECTORY
#!insertmacro MUI_PAGE_STARTMENU Application $StartMenuFolder
!insertmacro MUI_PAGE_INSTFILES
!insertmacro MUI_PAGE_FINISH

# Installer languages
!insertmacro MUI_LANGUAGE German

# Installer attributes
OutFile ${INSTALLNAME}
InstallDir $EXEDIR\${DIRNAME}
CRCCheck on
XPStyle on
ShowInstDetails show
VIProductVersion ${VERSION}.0
VIAddVersionKey /LANG=${LANG_GERMAN} ProductName "${LONGNAME}"
VIAddVersionKey /LANG=${LANG_GERMAN} ProductVersion "${VERSION}"
VIAddVersionKey /LANG=${LANG_GERMAN} CompanyName "${COMPANY}"
VIAddVersionKey /LANG=${LANG_GERMAN} CompanyWebsite "${URL}"
VIAddVersionKey /LANG=${LANG_GERMAN} FileVersion "${VERSION}"
VIAddVersionKey /LANG=${LANG_GERMAN} FileDescription ""
VIAddVersionKey /LANG=${LANG_GERMAN} LegalCopyright ""
InstallDirRegKey HKLM "${REGKEY}" Path
ShowUninstDetails show

# Installer sections
Section "${LONGNAME}" SEC_JAR
	SectionIn RO # required
	SetOverwrite on
	SetOutPath $INSTDIR
	File "${DIR_FILES}\${FILENAME}.jar"
	File "/oname=${FILENAME}.ico" "${DIR_RESOURCES}images\installer_icon.ico"
	WriteRegStr HKLM "${REGKEY}\Components" jar 1
SectionEnd

Section "Startmenü-Eintrag" SEC_SM
	SetOverwrite on
	CreateDirectory "$SMPROGRAMS\${LONGNAME}"
	CreateShortCut "$SMPROGRAMS\${LONGNAME}\${LONGNAME}.lnk" "$INSTDIR\${FILENAME}.jar" "" "$INSTDIR\${FILENAME}.ico"
SectionEnd

Section "Autostart-Eintrag" SEC_AS
	SetOverwrite on
	CreateShortCut "$SMSTARTUP\${LONGNAME}.lnk" "$INSTDIR\${FILENAME}.jar" "" "$INSTDIR\${FILENAME}.ico"
SectionEnd

# Component descriptions
!insertmacro MUI_FUNCTION_DESCRIPTION_BEGIN
	!insertmacro MUI_DESCRIPTION_TEXT ${SEC_JAR} "Die Programmdateien von $\"${LONGNAME}$\"."
	!insertmacro MUI_DESCRIPTION_TEXT ${SEC_SM} "Der Eintrag im Startmenü sorgt dafür, dass Sie $\"${LONGNAME}$\" bequem von Hand aus dem Startmenü starten können."
	!insertmacro MUI_DESCRIPTION_TEXT ${SEC_AS} "Dieser Eintrag sorgt dafür, dass $\"${LONGNAME}$\" bei jedem Rechnerstart automatisch ausgeführt wird."
!insertmacro MUI_FUNCTION_DESCRIPTION_END

# Installer functions
Function .onInit
	InitPluginsDir
	Push $R1
	File /oname=$PLUGINSDIR\spltmp.bmp "${DIR_RESOURCES}images\installer_splash.bmp"
	advsplash::show 1500 600 400 -1 $PLUGINSDIR\spltmp
	Pop $R1
	Pop $R1
FunctionEnd

Function CopyExisting
	IfFileExists "$INSTDIR\${FILENAME}.jar" 0 +4
		MessageBox MB_OKCANCEL|MB_ICONQUESTION "${LONGNAME} ist bereits im Installationsverzeichnis vorhanden. Soll es überschrieben werden?$\r$\n$\r$\nBei $\"Abbrechen$\" kann ein neues Verzeichnis ausgesucht werden." IDOK continue
		Abort
	continue:
FunctionEnd

# EOF
